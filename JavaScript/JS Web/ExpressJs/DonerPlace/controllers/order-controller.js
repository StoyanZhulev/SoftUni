const Doner = require('mongoose').model('Doner');
const Order = require('mongoose').model('Order');
const User = require('mongoose').model('User');


module.exports = {
    orderProductView: (req, res) => {
        let donerId = req.params.id;

        Doner.findById(donerId).then((doner) => {

            res.render('order/customize-order', { doner });
        })
    },
    orderProduct: (req, res) => {
        let reqObj = req.body;
        let donerId = reqObj.productId;

        let objKeys = Object.keys(reqObj);


        let orderToppings = [];
        for (let i = 1; i < objKeys.length; i++) {
            orderToppings.push(objKeys[i])
        }

        let dateOrdered = new Date(Date.now());
        dateOrdered = dateOrdered.toUTCString().substring(5, 22);


        Doner.findById(donerId).then(doner => {

            doner.toppings = orderToppings;

            let orderObj = {
                creator: req.user.username,
                product: doner,
                date: dateOrdered,
                status: 'Pending'
            }

            Order.create(orderObj).then(order => {
                let isPending = true;
                User.findById(req.user._id).then(user => {
                    user.orders.push(order);
                    user.save().then(user => {
                        res.render('order/order-details', { order, isPending })
                    })
                })
            })

        })
    },
    myOrders: (req, res) => {
        User.findById(req.user._id).populate('orders').then(user => {
            let orders = user.orders;
            res.render('order/order-status', { orders })
        })
    },
    orderDetails: (req, res) => {
        let orderId = req.params.id;
        Order.findById(orderId).then(order => {
            let status = order.status;
            let isPending = status === 'Pending';
            let isInProgress = status === 'In Progress';
            let isInTransit = status === 'In Transit';
            let isDelivered = status === 'Delivered';
            if (isPending) {
                res.render('order/order-details', { order, isPending })
            } else if (isInProgress) {
                res.render('order/order-details', { order, isInProgress })
            } else if (isInTransit) {
                res.render('order/order-details', { order, isInTransit })
            } else {
                res.render('order/order-details', { order, isDelivered })
            }
        })
    },
    getAllOrders: (req, res) => {
        Order.find({}).then(orders => {
            for (let order of orders) {
                let isPending = order.status === 'Pending';
                let isInProgress = order.status === 'In Progress';
                let isInTransit = order.status === 'In Transit';
                let isDelivered = order.status === 'Delivered';
                if (isPending) {
                    order.isPending = true;
                } else if (isInProgress) {
                    order.isInProgress = true;
                } else if (isInTransit) {
                    order.isInTransit = true;
                } else {
                    order.isDelivered = true;
                }
            }
            res.render('allOrders', { orders });
        })
    },
    saveOrders: (req, res) => {
        let reqObj = req.body;

        let ids = Object.keys(reqObj);

        let values = []
        for (let i = 0; i < ids.length; i++) {
            values.push(reqObj[ids[i]]);
        }

        Order.find({
            '_id': { $in: ids }
        }).then(orders => {
            for (let i = 0; i < orders.length; i++) {
                orders[i].status = values[i];
            }

            let promises = [];

            for (let i = 0; i < orders.length; i++) {
                promises.push(orders[i].save());
            }

            Promise.all(promises).then(e=>{
               
                for (let order of orders) {
                    let isPending = order.status === 'Pending';
                    let isInProgress = order.status === 'In Progress';
                    let isInTransit = order.status === 'In Transit';
                    let isDelivered = order.status === 'Delivered';
                    if (isPending) {
                        order.isPending = true;
                    } else if (isInProgress) {
                        order.isInProgress = true;
                    } else if (isInTransit) {
                        order.isInTransit = true;
                    } else {
                        order.isDelivered = true;
                    }
                }
                res.render('allOrders', { orders });
            })
           
        })
    }
}