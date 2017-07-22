function solve() {
    class Accessorie{
        constructor(manufacturer){
            if(new.target === Accessorie){
                throw new Error('Cannot instantiate directly.');
            }
            this.manufacturer = manufacturer;
        }
    }

    class Keyboard extends Accessorie{
        constructor(manufacturer, responseTime){
            super(manufacturer);
            this.responseTime = responseTime;
        }
    }

    class Monitor extends Accessorie{
        constructor(manufacturer, width, height){
            super(manufacturer);
            this.width = width;
            this.height = height;
        }
    }

    class Battery extends Accessorie{
        constructor(manufacturer, expectedLife){
            super(manufacturer);
            this.expectedLife = expectedLife;
        }
    }

    class Computer {
        constructor(manufacturer, processorSpeed, ram, hardDiskSpace){
            if(new.target === Computer){
                throw new Error('Cannot instantiate directly.');
            }
            this.manufacturer = manufacturer;
            this.processorSpeed = processorSpeed;
            this.ram = ram;
            this.hardDiskSpace = hardDiskSpace;
        }
    }

    class Laptop extends Computer{
        constructor(manufacturer, processorSpeed, ram, hardDiskSpace, weight, color, battery){
            super(manufacturer, processorSpeed, ram, hardDiskSpace);
            this.weight = weight;
            this.color = color;
            this.battery = battery;
        }

        get battery(){
            return this._battery;
        }

        set battery(battery){
            if(!(battery instanceof Battery)){
                throw new TypeError('Not an instance.')
            }
            this._battery = battery;
        }
    }

    class Desktop extends Computer{
        constructor(manufacturer, processorSpeed, ram, hardDiskSpace, keyboard, monitor){
            super(manufacturer, processorSpeed, ram, hardDiskSpace);
            this.keyboard = keyboard;
            this.monitor = monitor;
        }

        get keyboard(){
            return this._keyboard;
        }

        set keyboard(keyboard){
            if(!(keyboard instanceof Keyboard)){
                throw new TypeError('Not an instance.')
            }
            this._keyboard = keyboard;
        }

        get monitor(){
            return this._monitor;
        }

        set monitor(monitor){
            if(!(monitor instanceof Monitor)){
                throw new TypeError('Not an instance.')
            }
            this._monitor = monitor;
        }
    }

    return {
        Accessorie,
        Battery,
        Keyboard,
        Monitor,
        Computer,
        Laptop,
        Desktop
    }
}