function aggrrgateTable(towns) {
    let cities = [];
    let sum = 0;
    for (let town of towns) {
        let line = town.split(/\s*\|\s*/);
        cities.push( line[1]);
        sum += Number(line[2]);
    }

    console.log(cities.join(', '));
    console.log(sum);
}

aggrrgateTable(['| Sofia           | 300',
    '| Veliko Tarnovo  | 500',
    '| Yambol          | 275']
);