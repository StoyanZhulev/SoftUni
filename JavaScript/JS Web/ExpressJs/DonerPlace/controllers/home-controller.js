const restrictedPages = require('../config/auth');
const Doner = require('mongoose').model('Doner');

module.exports = {
    index: (req, res) => {
        Doner.find({}).then((doners) => {
            let beefDoners = doners.filter(d => d.categoryName === 'beef');
            let chickenDoners = doners.filter(d => d.categoryName === 'chicken');
            let lambDoners = doners.filter(d => d.categoryName === 'lamb');
            
            if (req.user) {
                if (restrictedPages.isAdmin(req.user)) {
                    res.render('home/index-admin', {beefDoners, chickenDoners, lambDoners});
                } else {
                    res.render('home/index', {beefDoners, chickenDoners, lambDoners});
                }
            }
            else {
                res.render('home/index', {beefDoners, chickenDoners, lambDoners});
            }
        })   
    },
};