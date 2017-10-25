const fs = require('fs');
const faviconPath = './public/images/favicon.ico';

let fileType = (dataString) => {
    let dataTypes = {
        'html': 'text/html',
        '.css': 'text/css',
        '.js': 'application/javascript',
        '.png': 'image/png',
        '.jpg': 'image/jpg',
        '.ico': 'image/x-icon'
    }

    for (let type in dataTypes) {
        if (dataString.endsWith(type)) {
            return dataTypes[type];
        }
    }
}

module.exports = (req, res) => {
    let path = req.pathname;

    if (path === '/favicon.ico') {
        path = '/public/images' + path;
    }

    if (path.startsWith('/public')) {
        fs.readFile('.' + path, (err, data) => {
            if (err) {
                console.log(err.message);
                return;
            }

            res.writeHead(200, {
                'content-type': fileType(req.pathname)
            })

            res.write(data);

            res.end();
        })
    } else {
        return true;
    }
}