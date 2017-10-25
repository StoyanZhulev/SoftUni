const Doner = require('mongoose').model('Doner');
const Order = require('mongoose').model('Order');
const User = require('mongoose').model('User');


module.exports = {
    createProductView: (req, res) => {
        res.render('product/create-product');
    },
    createProduct: (req, res) => {
        let categories = ['beef', 'chicken', 'lamb'];
        let reqObj = req.body;

        let categoryName = reqObj.category;
        let isValid = (categories.indexOf(categoryName) > -1);
        if (!isValid) {
            errorHandler('Invalid category');
            return;
        }
        let imageUrl = reqObj.imageUrl;
        if (imageUrl === '') {
            errorHandler('Set image url');
            return;
        }

        let size = reqObj.size;

        if (size < 17 || size > 24) {
            errorHandler('Size must be between 17 and 24');
            return;
        }

        let toppingsString = reqObj.toppings;

        let toppings = toppingsString.split(', ').filter(e => e !== '');

        let donerObj = {
            categoryName,
            size,
            imageUrl,
            toppings
        }

        Doner.create(donerObj).then((doner) => {
            res.redirect('/product/create');
        })

        function errorHandler(e) {
            console.log(e);
            res.locals.globalError = e;
            res.render('product/create-product');
        }
    },
    editProductView: (req, res)=> {
        let prId = req.params.id;

        Doner.findById(prId).then(doner => {
            res.render('product/edit', {doner});
            
        })
        
    },
    editProduct: (req, res) => {
        let categories = ['beef', 'chicken', 'lamb'];
        let reqObj = req.body;

        let prId = req.params.id;
         
        let categoryName = reqObj.category;
        let isValid = (categories.indexOf(categoryName) > -1);
        if (!isValid) {
            errorHandler('Invalid category');
            return;
        }
        let imageUrl = reqObj.imageUrl;


        if (imageUrl === '') {
            errorHandler('Set image url');
            return;
        }
        let size = reqObj.size;

        if (size < 17 || size > 24) {
            errorHandler('Size must be between 17 and 24');
            return;
        }

        let toppingsString = reqObj.toppings;

        let toppings = toppingsString.split(', ').filter(e => e !== '');

        let donerObj = {
            categoryName,
            size,
            imageUrl,
            toppings
        }

       Doner.findById(prId).then(d => {
           d.categoryName = donerObj.categoryName;
           d.size = donerObj.size;
           d.imageUrl = donerObj.imageUrl;
           d.toppings = donerObj.toppings;

           d.save().then(e=> {
               res.redirect('/')
           })
       })

        function errorHandler(e) {
            console.log(e);
            res.locals.globalError = e;
            res.render('product/create-product');
        }
    },
    delete: (req, res) => {
        let id = req.params.id;

        Doner.findByIdAndRemove(id).then(e => {
            res.redirect('/');
        })
    }
    
};