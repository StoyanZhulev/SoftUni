let express = require('express');
let router = express.Router();

const Genre = require('../models/Genre');

router.get('/', function(req, res, next) {
  res.render('addGenre');
}).post('/', function(req, res, next){
    Genre.create(req.body)
        .then(res.redirect('/'))
})

module.exports = router;
