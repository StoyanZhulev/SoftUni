function toJson(stringArr) {
    let towns = [];
    stringArr.shift();
    for (let str of stringArr) {
        let strTokens = str.split(/\s*\|\s*/).filter(e => e!== "");
        let town = strTokens[0];
        let lat = Number(strTokens[1]);
        let long = Number(strTokens[2]);

        let city = {Town: town, Latitude: lat, Longitude: long};
        towns.push(city);
    }

    return JSON.stringify(towns);
}

console.log(toJson(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']
));