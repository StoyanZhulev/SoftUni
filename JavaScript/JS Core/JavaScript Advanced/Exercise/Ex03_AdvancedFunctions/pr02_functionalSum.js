(function sum() {
    let result = 0;

    return function add(num) {
        result += num;

        add.toString = function () {
            return result;
        };

        return add;
    }
})();

//let adder = sum();
//console.log(adder(1)(6)(-3).toString());