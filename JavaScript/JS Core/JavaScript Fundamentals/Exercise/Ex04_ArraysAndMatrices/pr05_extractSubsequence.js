function extractSubsequence(arr) {
    let el = Number(arr[0]);
    let resultArr = [];
    resultArr.push(el);

    for (let i = 1; i < arr.map(e => Number(e)).length; i++) {
        if(el <= arr[i]){
            el = arr[i];
            resultArr.push(el);
        }
    }

    console.log(resultArr.join('\n'));
}


extractSubsequence([1,
    3,
    8,
    4,
    10,
    12,
    3,
    2,
    24
]);