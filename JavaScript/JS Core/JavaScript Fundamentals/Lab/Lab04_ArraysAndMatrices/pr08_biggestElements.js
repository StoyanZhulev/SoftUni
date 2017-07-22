let fun = matrix => console.log(Math.max.apply(null, matrix.reduce((row1, row2) => row1.concat(row2))));
function findBiggestElement(matrix) {
    let max = Number.NEGATIVE_INFINITY;
    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            if(matrix[row][col] > max){
                max = matrix[row][col];
            }
        }
    }

    return max;
}