function buildAWall(arr) {
    let numArr = arr.map(e => Number(e));
    let concretePerDay = [];
    let totalConcrete = 0;

    while (true){
        let count = 0;
        for (let i = 0; i < numArr.length; i++) {
            if(numArr[i] < 30){
                numArr[i]++;
                count++;
            }
        }

        if(count === 0){
            break;
        }

        concretePerDay.push(count * 195);
        totalConcrete += count * 195;
    }

    let sum = totalConcrete * 1900;

    console.log(concretePerDay.join(', '));
    console.log(sum + ' pesos');
}


buildAWall(['21', '25', '28']);