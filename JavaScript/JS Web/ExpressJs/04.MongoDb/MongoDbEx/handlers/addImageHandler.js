const formidable = require('formidable');
const fs = require('fs');

const Image = require('../models/ImageSchema');
const Tag = require('../models/TagSchema');

const getHome = require('./getHome');

function addImage(req, res){
  let form = new formidable.IncomingForm();

  form.parse(req, (err, fields, file) => {
    if(err){
      console.log(err);
      return;
    }

    let tags = fields['tagsID'].split(',');
    tags.pop();
    fields['tags'] = tags;

    delete fields['tagsID'];

    Image.create(fields).then((image) => {
      Tag.update(
        { _id: { $in: fields['tags'] } },
        { $push: { images: image._id } },
        { multi: true }
      ).then((e) => {
        getHome(res);
      })



      
      /*
      // for (let tagId of image['tags']) {
      //   Tag.findByIdAndUpdate(tagId).then((tag) => {
      //     tag['images'].push(image['_id']);
      //
      //     tag.save()
      //       .then((tag) => { })
      //       .catch((err) => { })
      //   })
      // }
      //
      // getHome(res);
      */
    }).catch(err => {
      console.log(err);
    })
  })
}

function deleteImg(req, res) {
  let id = req.pathquery['id'];

  Image.findOneAndRemove({ _id: id }, function(err, removed){
    if(err){
      console.log(err);
      return;
    }

    getHome(res);
  })
}
module.exports = (req, res) => {
  if (req.pathname === '/addImage' && req.method === 'POST') {
    addImage(req, res)
  } else if (req.pathname === '/delete' && req.method === 'GET') {
    deleteImg(req, res)
  } else {
    return true
  }
}
