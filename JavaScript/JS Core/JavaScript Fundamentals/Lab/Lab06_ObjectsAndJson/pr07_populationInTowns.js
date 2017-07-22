function calcPopulation(arrTowns) {
    let towns = new Map();
    for (let town of arrTowns) {
        let townTokens = town.split(' <-> ').filter(e => e !== '');
        let name = townTokens[0];
        let pop = Number(townTokens[1]);

        if(!towns.has(name)){
            towns.set(name, 0);
        }

        towns.set(name, towns.get(name) + pop);
    }


    for (let town of towns.keys()) {
        console.log(`${town} : ${towns.get(town)}`);
    }
}


calcPopulation(['Sofia <-> 1200000',
'Montana <-> 20000',
'New York <-> 10000000',
'Washington <-> 2345000',
'Las Vegas <-> 1000000'
]);