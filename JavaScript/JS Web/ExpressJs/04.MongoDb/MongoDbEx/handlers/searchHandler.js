const formidable = require('formidable');
const fs = require('fs');

const Image = require('../models/ImageSchema');
const Tag = require('../models/TagSchema');


module.exports = (req, res) => {
  if (req.pathname === '/search') {
   let constraints = req.pathquery;

   if(constraints['Limit'] === ''){
     constraints['Limit'] = Number.MAX_VALUE;
   }

   constraints['tagName'] = constraints['tagName'].split(', ');

   Tag.find(
     { tagName: { $in: constraints['tagName'] } },
     { multi: true }
    ).then((tags) => {
      Image.find({})
      .then((images) => {
        let searched = [];
        for (let img of images) {
          if(Number(constraints['Limit']) <= searched.length){
            break;
          }

          if(mathcesRequirements(img, tags, constraints)){
            searched.push(img)
          }
        }

        let html = '';
        for (let image  of searched) {
          html += `<fieldset id => <legend>${image.imageTitle}:</legend> 
          <img src="${image.imageUrl}">
          </img><p>${image.description}<p/>
          <button onclick='location.href="/delete?id=${image._id}"'class='deleteBtn'>Delete
          </button> 
          </fieldset>`
        }

        fs.readFile('./views/results.html', (err, data) => {
          if(err){
            console.log(err);
            return;
          }

          dadta = data.toString().replace("<div class='replaceMe'></div>", html);
          res.writeHead(200, {
            'content-type': 'text/html'
          });

          res.write(data);

          res.end();
        })
      })
    })
  } else {
    return true
  }
}


function mathcesRequirements(image, tags, constraints){
  let result = new Date(image['creationDate']) >= new Date(constraints['afterDate']) &&
               new Date(image['creationDate']) <= new Date(constraints['beforeDate']);

  if(result === false){
    return false;
  }

  for (let tagId of image['tags']) {
    for (let id of tags) {
      if ((id['_id'] + '') === (tagId + '')) {
        return true
      }
    }
  }

  return false;
}
