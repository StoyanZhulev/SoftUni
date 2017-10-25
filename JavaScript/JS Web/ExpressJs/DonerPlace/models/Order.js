const mongoose = require('mongoose')
const ObjectId = mongoose.Schema.Types.ObjectId

let orderSchema = new mongoose.Schema({
    creator:{type:String,required:true},
    product: {type: Object, required: true},
    date: {type: String, required: true},
    status: {type: String, required: true, default: 'Pending'}
})



module.exports = mongoose.model('Order',orderSchema)