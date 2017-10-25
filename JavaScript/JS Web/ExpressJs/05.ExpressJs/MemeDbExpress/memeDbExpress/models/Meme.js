const mongoose = require('mongoose');
const ObjectId = mongoose.Schema.Types.ObjectId;

let memeSchema = new mongoose.Schema({
    title: {type: String, required: true},
    description: {type: String, required: true},
    dateOfCreation: {type: Date, default: Date.now()}
});

module.exports = mongoose.model('Meme', memeSchema);