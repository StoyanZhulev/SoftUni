function average(num) {
    let numString = ''+num;
    function findAverage(numString) {
        let sum = 0;
        for (let i = 0; i < numString.length; i++) {
            sum += Number(numString[i]);
        }
        return sum / numString.length;
    }

    let average = findAverage(numString);
    while (average <=5){
        numString += 9;
        average = findAverage(numString);
    }

    console.log(numString);
}

average(101);