const homeHandler = require('./homeHandler.js');
const staticHandler = require('./static-handler.js');
const movieHandler = require('./movieHandler');

module.exports = [ homeHandler,movieHandler, staticHandler ];