function calcIncome(arr) {
    let towns = new Map();

    for (let town of arr) {
        let townTokens = town.split(' -> ');
        let name = townTokens[0];
        let product = townTokens[1];
        let salesAndPrice = townTokens[2].split(' : ');
        let sales = Number(salesAndPrice[0]);
        let pricePerUnit = Number(salesAndPrice[1]);
        let price = sales * pricePerUnit;

        if(!towns.has(name)){
            towns.set(name, new Map());
        }
        if(!towns.get(name).has(product)){
            towns.get(name).set(product, 0);
        }

        towns.get(name).set(product, towns.get(name).get(product) + price);
    }

    for (let town of towns.keys()) {
        console.log(`Town - ${town}`);
        for (let product of towns.get(town).keys()) {
            console.log(`$$$${product} : ${towns.get(town).get(product)}`);
        }
    }

    // [...towns].forEach(([town, product]) => {
    //     console.log(`Town - ${town}`);
    //     [...product].forEach(([productName, price]) => {
    //         console.log(`$$$${productName} : ${price}`);
    //     })
    // });
}

calcIncome(['Sofia -> Laptops HP -> 200 : 2000',
'Sofia -> Raspberry -> 200000 : 1500',
'Sofia -> Audi Q7 -> 200 : 100000',
'Montana -> Portokals -> 200000 : 1',
'Montana -> Qgodas -> 20000 : 0.2',
'Montana -> Chereshas -> 1000 : 0.3'
]);