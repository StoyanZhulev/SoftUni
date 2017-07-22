function lowestPrice(arr) {
    let productPrice = new Map();
    let productTown = new Map();

    for (let pr of arr) {
        let [townName, prName, prPrice] = pr.split(' | ');

        if(!productPrice.has(prName)){
            productTown.set(prName, townName);
            productPrice.set(prName, Number.POSITIVE_INFINITY);
        }

        if(productPrice.get(prName) > Number(prPrice)){
            productPrice.set(prName, Number(prPrice));
            productTown.set(prName, townName);
        }
    }

    [...productPrice].forEach(([pr, price]) => {
        console.log(`${pr} -> ${price} (${productTown.get(pr)})`);
    })
}


lowestPrice(['Sofia City | Audi | 100000',
   'Sofia City | BMW | 100000',
    'Sofia City | Mitsubishi | 10000',
    'Sofia City | Mercedes | 10000',
    'Sofia City | NoOffenseToCarLovers | 0',
    'Mexico City | Audi | 1000',
    'Mexico City | BMW | 99999',
    'New York City | Mitsubishi | 10000',
    'New York City | Mitsubishi | 1000',
    'Mexico City | Audi | 100000',
    'Washington City | Mercedes | 1000',
]);