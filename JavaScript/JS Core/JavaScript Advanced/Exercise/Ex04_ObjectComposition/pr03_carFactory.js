function carFactory() {
    let storage = {
        engine: {
            smallEngine: {
                power: 90,
                volume: 1800
            },
            normalEngine: {
                power: 120,
                volume: 2400
            },
            monsterEngine: {
                power: 200,
                volume: 3500
            }
        },
        carriage: {
            hatchback: {
                type: 'hatchback'
            },
            coupe: {
                type: 'coupe'
            }
        }
    };

    return function makeCar(carReq) {
        let reqModel = carReq.model;
        let reqPower = carReq.power;
        let reqColor = carReq.color;
        let reqCarriage = carReq.carriage;
        let wheelsSize = Number(carReq.wheelsize);

        let car = {};
        car.model = reqModel;
        if(reqPower <= 90){
            car.engine = storage['engine']['smallEngine'];
        }else if(reqPower <= 120){
            car.engine = storage.engine.normalEngine;
        }else{
            car.engine = storage.engine.monsterEngine;
        }

        car.carriage = storage.carriage[reqCarriage];
        car.carriage.color = reqColor;

        wheelsSize = wheelsSize % 2 === 0 ? wheelsSize - 1 : wheelsSize;
        car.wheels = [wheelsSize, wheelsSize, wheelsSize, wheelsSize];

        return car;
    }
}

let factory = carFactory();
console.log(factory({ model: 'Opel Vectra',
    power: 110,
    color: 'grey',
    carriage: 'coupe',
    wheelsize: 17 }

));