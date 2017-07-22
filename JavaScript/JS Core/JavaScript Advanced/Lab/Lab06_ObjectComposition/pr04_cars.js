function solve(arr) {
     let cars = new Map();

     let processor = {
         create: function (name) {
             let car = {};
             cars.set(name, car);
         },
         inherit: function (name, par) {
             let parent = cars.get(par);
             let car = Object.create(parent);
             cars.set(name, car);
         },
         set: function (name, key, value) {
             cars.get(name)[key] = value;
         },
         print: function (name) {
             let car = cars.get(name);
             let props = [];
             for (let prop in car) {
                 props.push(`${prop}:${car[prop]}`);
             }
             console.log(props.join(', '));
         }
     };

    for (let cmd of arr) {
        let cmdArgs = cmd.split(' ');
        let command = cmdArgs[0];
        switch (command){
            case 'create':
                if(cmdArgs.length > 2){
                    processor.inherit(cmdArgs[1], cmdArgs[3]);
                }else{
                    processor.create(cmdArgs[1]);
                }
                break;
            case 'set':
                processor.set(cmdArgs[1], cmdArgs[2], cmdArgs[3]);
                break;
            case 'print':
                processor.print(cmdArgs[1]);
                break;
        }

    }
}
solve(['create c1',
    'create c2 inherit c1',
    'set c1 color red',
    'set c2 model new',
    'print c1',
    'print c2']
);