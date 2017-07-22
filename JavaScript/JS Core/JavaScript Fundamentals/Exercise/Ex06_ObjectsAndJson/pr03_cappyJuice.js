function juice(arr) {
    let juices = new Map();
    let bottles = new Map();

    for (let juice of arr) {
        let juiceTokens = juice.split(' => ');
        let name = juiceTokens[0];
        let quantity = Number(juiceTokens[1]);

        if(!juices.has(name)){
            juices.set(name, 0);
        }

        juices.set(name, juices.get(name) + quantity);

        if(juices.get(name) >= 1000){
            let bots = parseInt(juices.get(name) / 1000);
            let left = juices.get(name) - (1000 * bots);
            juices.set(name, left);

            if(!bottles.has(name)){
                bottles.set(name, 0);
            }

            bottles.set(name, bottles.get(name) + bots)
        }
    }

    for (let bot of bottles.keys()) {
        console.log(`${bot} => ${bottles.get(bot)}`);
    }
}

juice(['Kiwi => 234',
    'Pear => 2345',
    'Watermelon => 3456',
    'Kiwi => 4567',
    'Pear => 5678',
    'Watermelon => 6789'
]);