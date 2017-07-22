function makeArray(arr) {

    let resArray = [];

    for (let num of arr) {
        Number(num) < 0 ? resArray.unshift(num) : resArray.push(num);
    }
    return resArray.join('\n');
}

console.log(makeArray([7, -2, 8, 9]));