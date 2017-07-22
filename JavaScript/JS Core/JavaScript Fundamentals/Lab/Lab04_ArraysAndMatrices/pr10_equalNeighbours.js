function findEquals(matrix) {
    let count = 0;
    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            if((isInMatrix(matrix, row + 1, col)) && matrix[row][col] === matrix[row + 1][col]){
                count++;
            }
            if((isInMatrix(matrix, row, col + 1)) && matrix[row][col] === matrix[row][col + 1]){
                count++;
            }
        }
    }
    function isInMatrix(matrix, row, col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    return count;
}
