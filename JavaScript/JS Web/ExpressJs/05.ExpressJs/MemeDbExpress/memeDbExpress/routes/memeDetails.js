let express = require('express');
let router = express.Router();

const Meme = require('../models/Meme');

router.get('/', function (req, res, next) {

    let memeId = req.query.id;
    Meme.findById(memeId)
        .then((meme) => {
            res.render('details', {meme})
        })
})

module.exports = router;