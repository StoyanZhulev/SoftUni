function cookByNumbers(arr) {
    let num = Number(arr[0]);

    for (let i = 1; i < arr.length; i++) {
        num = operation(num, arr[i]);
        console.log(num);
    }

    function operation(num, op) {
        switch (op){
            case 'chop':
                return num / 2;
            case 'dice':
                return Math.sqrt(num);
            case 'spice':
                return num + 1;
            case 'bake':
                return num * 3;
            case 'fillet':
                return num - num * 0.2;
        }
    }
}

cookByNumbers([32, 'chop', "chop", 'chop', 'chop', 'chop']);