const formidable = require('formidable');
const fs = require('fs');

const getHome = require('./getHome');
const Tag = require('../models/TagSchema');

function generateTag(req, res) {
  let form = new formidable.IncomingForm();

  form.parse(req, (err, fields, file) => {
    if (err) {
      console.log(err);
      return;
    }

    Tag.create(fields).then((tag) => {
      getHome(res);
    }).catch((err) => {
      console.log(err);
    })
  })
}

module.exports = (req, res) => {
  if (req.pathname === '/generateTag' && req.method === 'POST') {
    generateTag(req, res);
  } else {
    return true
  }
}
