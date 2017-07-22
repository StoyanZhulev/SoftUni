function makeRobot() {
    let meals = {
        apple: {
            carbohydrate : 1,
            flavour: 2
        },
        coke: {
            carbohydrate : 10,
            flavour: 20
        },
        burger: {
            carbohydrate : 5,
            fat: 7,
            flavour: 3
        },
        omelet: {
            protein: 5,
            fat: 1,
            flavour: 1
        },
        cheverme: {
            protein: 10,
            carbohydrate : 10,
            fat: 10,
            flavour: 10
        }
    };

    let stock = {
        protein: 0,
        carbohydrate : 0,
        fat: 0,
        flavour: 0
    };
    return function (command) {
        let cmdArgs = command.split(' ');
        let quantity;
        switch (cmdArgs[0]){
            case 'restock':
                let element = cmdArgs[1];
                quantity = Number(cmdArgs[2]);
                stock[element] += quantity;
                return 'Success';
                break;
            case 'prepare':
                let recipe = cmdArgs[1];
                quantity = Number(cmdArgs[2]);
                let meal = meals[recipe];
                for (let ingr in meal) {
                    if(meal[ingr] * quantity > stock[ingr] * quantity){
                        return `Error: not enough ${ingr} in stock`;
                    }
                }

                for (let ingr in meal) {
                    stock[ingr] -= meal[ingr] * quantity;
                }

                return 'Success';
                break;
            case 'report':
                let res = `protein=${stock['protein']} carbohydrate=${stock['carbohydrate']} fat=${stock['fat']} flavour=${stock['flavour']}`;
                return res;
                break;
        }
    }
}


let robot = makeRobot();
console.log(robot('prepare cheverme 1')); // Success
console.log(robot('restock protein 10'));
console.log(robot('prepare cheverme 1'));
console.log(robot('restock carbohydrate 10'));
console.log(robot('prepare cheverme 1'));
console.log(robot("restock fat 10"));
console.log(robot('prepare cheverme 1'));
console.log(robot('restock flavour 10'));

console.log(robot('prepare cheverme 1'));
console.log(robot('report'));
