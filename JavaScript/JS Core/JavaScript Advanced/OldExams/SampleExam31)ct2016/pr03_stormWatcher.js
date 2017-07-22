(function solve() {
    let id = 0;
    return class Record{
        constructor(temperature, humidity, pressure, windSpeed){
            this.id = id++;
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            this.windSpeed = windSpeed;
        }

        getStatus(){
            if(this.temperature < 20 && (this.pressure < 700 || this.pressure > 900) && this.windSpeed > 25){
                return 'Stormy';
            }

            return 'Not stormy';
        }


        toString(){
            let out = `Reading ID: ${this.id}\n`;
            out += `Temperature: ${this.temperature}*C\n`;
            out += `Relative Humidity: ${this.humidity}%\n`;
            out += `Pressure: ${this.pressure}hpa\n`;
            out += `Wind Speed: ${this.windSpeed}m/s\n`;
            out += `Weather: ${this.getStatus()}`;

            return out;
        }
    }
})();