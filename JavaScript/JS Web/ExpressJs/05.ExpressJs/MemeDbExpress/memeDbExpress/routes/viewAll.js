let express = require('express');
let router = express.Router();

const Meme = require('../models/Meme');

/* GET viewAll page. */
router.get('/', function (req, res, next) {
    Meme.find({})
        .then((memes) => {
            res.render('viewAll', { memes });
        })
});

module.exports = router;
