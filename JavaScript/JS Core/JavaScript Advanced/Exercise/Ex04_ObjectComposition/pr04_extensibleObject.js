function solve() {
    return {
        extend: function (otherObj) {
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
    };
}