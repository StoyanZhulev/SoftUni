function isMagic(matrix) {
    matrix.map(e => Number(e));
    let sum = 0;
    for (let row = 0; row < 1; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            sum+= matrix[row][col];
        }
    }
    let tempSum =0;
    for (let row = 1; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            tempSum += matrix[row][col];
        }
        if(tempSum !== sum){
            return false;
        }
        tempSum = 0;
    }

    for (let col = 0; col < matrix.length; col++) {
        for (let row = 0; row < matrix.length; row++) {
            tempSum += matrix[col][row];
        }
        if(tempSum !== sum){
            return false;
        }
        tempSum = 0;
    }

    return true;
}


console.log(isMagic([[11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]]
));