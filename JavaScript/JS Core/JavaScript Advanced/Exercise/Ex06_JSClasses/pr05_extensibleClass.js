(function solve() {
    let id = 0;
    class Extensible{
        constructor(){
            this.id = id++;
        }

        extend(otherObj){
            let keys = Object.keys(otherObj);
            for (let key of keys) {
                let property = otherObj[key];
                if (typeof property === 'function') {
                    Object.getPrototypeOf(this)[key] = property;
                } else {
                    this[key] = property;
                }
            }
        }
    }

    return Extensible;
})();