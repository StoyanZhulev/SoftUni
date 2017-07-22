function attack(matrix) {
    for (let i = 0; i < matrix.length; i++) {
        matrix[i] = matrix[i].split(/\s+/).map(e => Number(e));
    }
    function calcPrimary(matrix) {
        let primaryDiagonal = 0;
        for (let row = 0; row < matrix.length; row++) {
            for (let col = row; col <= row; col++) {
                primaryDiagonal += Number(matrix[row][col]);
            }
        }

        return primaryDiagonal;
    }

    function calcSecondary(matrix) {
        let secondaryDiagonal = 0;
        let collIndex = 0;
        for (let row = matrix.length - 1; row >= 0; row--) {
            secondaryDiagonal += Number(matrix[row][collIndex++]);
        }

        return secondaryDiagonal;
    }

    let primary = calcPrimary(matrix);
    let secondary = calcSecondary(matrix);
    if(primary === secondary){
        let collIndex = matrix.length - 1;
        for (let row = 0; row < matrix.length; row++) {
            for (let col = 0; col < matrix[row].length; col++ ) {
                if(col !== row &&  col !== collIndex /*matrix.length - 1 - row*/){
                   matrix[row][col] = primary;
                }
            }
            collIndex--;
        }
    }
    printMatrix(matrix);

    function printMatrix(matrix) {
        for (let row = 0; row < matrix.length; row++) {
            console.log(matrix[row].join(' '));
        }
    }
}


attack(['5 3 12 3 1',
    '11 4 23 2 5',
    '101 12 3 21 10',
    '1 4 5 2 2',
    '5 22 33 11 1']

);


