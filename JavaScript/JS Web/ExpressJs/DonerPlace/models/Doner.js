const mongoose = require('mongoose')
const ObjectId = mongoose.Schema.Types.ObjectId

let donerSchema = new mongoose.Schema({
    categoryName:{type:String,required:true},
    size: {type: Number, required: true},
    imageUrl: {type: String, required: true},
    toppings:[{type:String}]
})



module.exports = mongoose.model('Doner',donerSchema)