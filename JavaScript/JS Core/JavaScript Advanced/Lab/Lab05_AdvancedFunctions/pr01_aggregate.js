function aggregate(numArr) {
    function reduce(arr, func) {
        let result = arr[0];
        for (let num of arr.slice(1)) {
            result = func(result, num);
        }
        return result;
    }


    console.log(`Sum = ${reduce(numArr, (a, b) => a + b)}`);
    console.log(`Min = ${reduce(numArr, (a, b) => a < b ? a : b)}`);
    console.log(`Max = ${reduce(numArr, (a, b) => Math.max(a, b))}`);
    console.log(`Product = ${reduce(numArr, (a, b) => a * b)}`);
    console.log(`Join = ${reduce(numArr, (a, b) => ''+ a + b)}`);
}

aggregate([2,3,10,5]);

