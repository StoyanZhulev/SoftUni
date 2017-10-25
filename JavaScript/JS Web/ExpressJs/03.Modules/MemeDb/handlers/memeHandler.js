const fs = require('fs');
const db = require('../config/dataBase.js');

const formidable = require('formidable')
const shortid = require('shortId');
const qs = require('querystring');
const url = require('url');

const viewAllPath = './views/viewAll.html';
const viewAddMemePath = './views/addMeme.html';
const getDetailsPath = './views/details.html';



let viewAll = (req, res) => {
  fs.readFile(viewAllPath, (err, data) => {
    if (err) {
      console.log(err);
      return;
    }

    res.writeHead(200, {
      'content-type': 'text/html'
    });


    let memes = db.getDb();

    memes = memes.filter(a => a['privacy']).sort((a, b) => b.timeStamp - a.timeStamp);

    let memeString = getMemesString(memes);

    data = data.toString().replace('<div id="replaceMe">{{replaceMe}}</div>', memeString);

    res.write(data);

    res.end()
  })
}

function getMemesString(memes) {
  let memesString = ''
  for (let meme of memes) {
    memesString += `<div class="meme">
    <a href="/getDetails?id=${meme.id}">
    <img class="memePoster" src="${meme.memeSrc}"/>          
</div>`
  }

  return memesString;
}

let viewAddMeme = (req, res) => {
  fs.readFile(viewAddMemePath, (err, data) => {
    if (err) {
      console.log(err);
      return;
    }

    res.writeHead(200, {
      'content-type': 'text/html'
    });

    res.write(data);

    res.end();
  })
}

let addMeme = (req, res) => {
  let form = new formidable.IncomingForm();

  let dir = Math.floor(db.length / 10);
  let id = shortid.generate();

  let path = `./public/memeStorage/${dir}`;

  let memePath = path + `/${id}.jpg`;


  form.on('fileBegin', function (name, file) {
    if (!fs.existsSync(path)) {
      fs.mkdirSync(path);
    }

    file.path = memePath
  });

  form.parse(req, (err, fields, files) => {
    let meme = createMeme(id, fields['memeTitle'], memePath, fields['memeDescription'], fields['status']);
    db.add(meme);
    db.save();

    viewAll(req, res);
  })
}

let getDetails = (req, res) => {
  fs.readFile(getDetailsPath, (err, data) => {
   
    let memeId = qs.parse(url.parse(req.url).query).id;

    let meme = db.getMemeById(memeId);


    if (meme) {
      let memeHtml = `<div class="content">
      <img src="${meme.memeSrc}" alt=""/>
      <h3>${meme.title}</h3>
      <p> ${meme.description}</p>
      <button><a href="${meme.memeSrc}" download="${meme.id}.jpg">Download Meme</a></button>
      </div>`;

      res.writeHead(200, {
        'content-type': 'text/html'
      });


      data = data.toString().replace('<div id="replaceMe">{{replaceMe}}</div>', memeHtml);

      res.write(data);

      res.end();
    } else {
      //TODO: 404 error page

      res.end();
    }
  })
}
function createMeme(id, title, memeSrc, description, privacy) {
  return {
    id: id,
    title: title,
    memeSrc: memeSrc,
    description: description,
    privacy: privacy,
    dateStamp: Date.now(),
  }
}

module.exports = (req, res) => {
  if (req.pathname === '/viewAllMemes' && req.method === 'GET') {
    viewAll(req, res)
  } else if (req.pathname === '/addMeme' && req.method === 'GET') {
    viewAddMeme(req, res)
  } else if (req.pathname === '/addMeme' && req.method === 'POST') {
    addMeme(req, res)
  } else if (req.pathname.startsWith('/getDetails') && req.method === 'GET') {
    getDetails(req, res)
  } else {
    return true
  }
}

