const express = require('express');
const router = express.Router();

const Genre = require('../models/Genre');
const Meme = require('../models/Meme');

router.get('/', function (req, res, next) {
    Genre.find({}).then((genres) => {
        genres.unshift({ name: 'All' });
        res.render('searchMeme', { genres });
    })
}).post('/', function (req, res, next) {
    let reqBody = req.body;
    let memeTitle = reqBody.memeTitle;
    let genreSelect = reqBody.genreSelect;

    if (memeTitle) {
        if (genreSelect) {
            Genre.findById(genreSelect)
                .populate('memes')
                .then((genre) => {
                    let memes = genre.memes;

                    let foundMemes = [];
                    for (let meme of memes) {
                        if (meme.title.toLowerCase().includes(reqBody.memeTitle.toLowerCase())) {
                            foundMemes.push(meme)
                        }
                    }
                    memes = foundMemes;

                    res.render('viewAll', { memes });
                })
        } else {
            Meme.find({}).then((memes) => {
                let foundMemes = [];
                for (let meme of memes) {
                    console.log(meme.title);
                    if (meme.title.toLowerCase().includes(reqBody.memeTitle.toLowerCase())) {
                        foundMemes.push(meme)
                    }
                }
                memes = foundMemes;
                res.render('viewAll', { memes });
            })
        }
    } else {
        if (genreSelect) {
            Genre.findById(genreSelect)
                .populate('memes')
                .then((genre) => {
                    let memes = genre.memes;

                    res.render('viewAll', { memes });
                })
        } else {
            Meme.find({}).then((memes) => {
                res.render('viewAll', {memes});
            })
        }
    }
})

module.exports = router;