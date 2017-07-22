function printNums(n, k) {
    let arr = [];
    arr.push(1);
    while (arr.length < n){
        let reduced = arr.slice(-k).reduce((a, b) => a + b);
        arr.push(reduced);
    }

    return arr.join(' ');
}

console.log(printNums(8, 2));
