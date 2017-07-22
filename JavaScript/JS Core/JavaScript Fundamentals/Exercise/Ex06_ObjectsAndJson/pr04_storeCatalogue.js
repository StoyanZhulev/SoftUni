function storeCatalogue(arr) {
    let catalogue = new Map();

    for (let obj of arr) {
        let tokens = obj.split(" : ");
        let product = tokens[0];
        let price = Number(tokens[1]);
        let char = product[0];

        if(!catalogue.has(char)){
            catalogue.set(char, new Map());
        }

        catalogue.get(char).set(product, price);
    }

    [...catalogue.keys()]
        .sort((a, b) => a.localeCompare(b))
        .forEach(key => {
            console.log(key);
            [...catalogue.get(key).keys()]
                .sort((a, b) => a.localeCompare(b))
                .forEach(k => console.log(`  ${k}: ${catalogue.get(key).get(k)}`))
        });
}


storeCatalogue(['Appricot : 20.4',
'Fridge : 1500',
'TV : 1499',
'Deodorant : 10',
'Boiler : 300',
'Apple : 1.25',
'Anti-Bug Spray : 15',
'T-Shirt : 10'
]);