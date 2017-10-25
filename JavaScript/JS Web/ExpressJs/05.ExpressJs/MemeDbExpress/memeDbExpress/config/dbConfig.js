const mongoose = require('mongoose');
const path = 'mongodb://localhost/memedb';

mongoose.Promise = global.Promise;

module.exports = mongoose.connect(path, {
    useMongoClient: true
})