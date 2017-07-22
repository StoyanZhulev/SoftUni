function calcSpiceAmount(numStr) {
    let yields = Number(numStr);
    let spices = 0;
    let days = 0;
    while (yields >= 100) {
        spices += yields;
        days++;
        yields -= 10;

        spices -= 26;

    }

    if (spices >= 26) {
        spices -= 26;
    }

    console.log(days);
    console.log(spices);
}


calcSpiceAmount('111');


