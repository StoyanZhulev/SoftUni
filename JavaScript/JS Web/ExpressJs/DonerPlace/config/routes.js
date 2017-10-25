const controllers = require('../controllers');
const restrictedPages = require('./auth');

module.exports = app => {
    app.get('/', controllers.home.index);
    app.get('/register', controllers.user.registerGet);
    app.post('/register', controllers.user.registerPost);
    app.get('/logout', controllers.user.logout);
    app.get('/login', controllers.user.loginGet);
    app.post('/login', controllers.user.loginPost);


    app.get('/product/create', restrictedPages.hasRole('Admin'), controllers.product.createProductView);
    app.post('/product/create', controllers.product.createProduct);
    app.get('/product/edit/:id', restrictedPages.hasRole('Admin'), controllers.product.editProductView);
    app.post('/product/edit/:id', restrictedPages.hasRole('Admin'), controllers.product.editProduct);
    app.get('/product/delete/:id', restrictedPages.hasRole('Admin'), controllers.product.delete);
    

    app.get('/order/:id',restrictedPages.isAuthed,  controllers.order.orderProductView);
    app.post('/order/:id',restrictedPages.isAuthed,  controllers.order.orderProduct);

    app.get('/myOrders',restrictedPages.isAuthed,  controllers.order.myOrders);
    app.get('/order/details/:id',restrictedPages.isAuthed,  controllers.order.orderDetails);


    app.get('/allOrders',restrictedPages.hasRole('Admin'),  controllers.order.getAllOrders);
    app.post('/allOrders',restrictedPages.isAuthed,  controllers.order.saveOrders);
    

    app.all('*', (req, res) => {
        res.status(404);
        res.send('404 Not Found');
        res.end();
    });
};