function carRegistry(arr) {
    let cars = new Map();

    for (let obj of arr) {
        let carTokens = obj.split(' | ');
        let brand = carTokens[0];
        let model = carTokens[1];
        let quantity = Number(carTokens[2]);

        if(!cars.has(brand)){
            cars.set(brand, new Map());
        }

        if(!cars.get(brand).has(model)){
            cars.get(brand).set(model, 0);
        }

        cars.get(brand).set(model, cars.get(brand).get(model) + quantity);
    }

    for (let brand of cars.keys()) {
        console.log(brand);
        for (let model of cars.get(brand).keys()) {
            console.log(`###${model} -> ${cars.get(brand).get(model)}`);
        }
    }
}