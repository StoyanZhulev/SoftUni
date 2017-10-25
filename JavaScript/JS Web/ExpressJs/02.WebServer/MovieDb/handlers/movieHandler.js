const fs = require('fs');
const db = require('../config/dataBase.js');
const querystring = require('querystring');

const addMoviePath = './views/addMovie.html';
const viewAllMoviePath = './views/viewAll.html';
const detailsPath = './views/details.html';

function getAddMovieForm(req, res) {
    fs.readFile(addMoviePath, (err, data) => {
        if (err) {
            console.log(err);
            return;
        }

        res.writeHead(200, {
            'content-type': 'text/html'
        })

        res.write(data);

        res.end();
    })
}

function addNewMovie(req, res) {
    let body = [];
    //Info that comes in peaces is pushed in the array
    req.on('data', movieData => {
        body.push(movieData);
    }).on('end', () => {
        body = Buffer.concat(body).toString();
        let movieBody = querystring.parse(body);

        let validMovie = true;

        for (let prop in movieBody) {
            if (movieBody[prop] === '') {
                validMovie = false;
                break;
            }
        }

        if (validMovie) {
            db.push(movieBody);

            fs.readFile(addMoviePath, (err, data) => {
                if (err) {
                    console.log(err);
                    return;
                }

                data = data.toString().replace('<div id="replaceMe">{{replaceMe}}</div>', '<div id="succssesBox"><h2 id="succssesMsg">Movie Added</h2></div>');

                res.writeHead(200, {
                    'content-type': 'text/html'
                })

                res.write(data);

                res.end();

            })
        } else {
            fs.readFile(addMoviePath, (err, data) => {
                if (err) {
                    console.log(err);
                    return;
                }

                data = data.toString().replace('<div id="replaceMe">{{replaceMe}}</div>', '<div id="errBox"><h2 id="errMsg">Please fill all fields</h2></div>');


                res.writeHead(200, {
                    'content-type': 'text/html'
                })

                res.write(data);

                res.end();
            })

        }
    })

}

function viewAllMovies(req, res) {
    fs.readFile(viewAllMoviePath, (err, data) => {
        if (err) {
            console.log(err['message']);
            return;
        }


        res.writeHead(200, {
            'content-type': 'text/html'
        });

        let moviesSorted = db.sort((a, b) => a.movieYear - b.movieYear);

        let movies = getMovies(moviesSorted);

        data = data.toString().replace('<div id="replaceMe">{{replaceMe}}</div>', movies);

        res.write(data);

        res.end();

    })
}

function getMovies(moviesSorted) {
    let movies = '';
    let movieId = 1;

    for (let movie of moviesSorted) {
        movies += `<div class="movie">
                    <a href="/movies/details/${movieId++}"><img class="moviePoster" src="${unescape(movie['moviePoster'])}"/> </a>
                  </div>`;

    }

    return movies;
}

function getMovie(id) {
    let movieId = 1;

    for (let movie of db) {
        if (movieId === id) {
            return `<div class="content">
            <img src="${unescape(movie['moviePoster'])}" alt=""/>
            <h3>Title:  ${unescape(movie['movieTitle']).replace(/\+/g, ' ')}</h3>
            <h3>Year: ${movie['movieYear']}</h3>
            <p>${unescape(movie['movieDescription']).replace(/\+/g, ' ')}</p>
            </div>`;
        }

        movieId++;
    }
}

module.exports = (req, res) => {
    if (req.pathname === '/addMovie' && req.method === 'GET') {
        getAddMovieForm(req, res);
    } else if (req.pathname === '/addMovie' && req.method === 'POST') {
        addNewMovie(req, res);
    } else if (req.pathname === '/viewAllMovies' && req.method === 'GET') {
        viewAllMovies(req, res);
    } else if (req.pathname.startsWith('/movies/details/')) {
        fs.readFile(detailsPath, (err, data) => {
            if (err) {
                console.log(err['message']);
                return;
            }

            res.writeHead(200, {
                'content-type': 'text/html'
            });

            let id = Number(req.pathname.substring(req.pathname.lastIndexOf('/') + 1));

            let movie = getMovie(id);

            data = data.toString().replace('<div id="replaceMe">{{replaceMe}}</div>', movie);

            res.write(data);

            res.end();
        })
    } else {
        return true;
    }
}