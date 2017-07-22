function fillSpiralMatrix(rows, cols) {
    let isFull = false;
    let num = 1;
    let iter = 0;
    let count = rows * cols;

    let matrix = [];
    for(let i=0; i<rows; i++) {
        matrix[i] = new Array(cols);
    }
    for (let row = 0; row < rows; row++) {
        for (let col = 0; col < cols; col++) {
            matrix[row][col] = 0;
        }
    }

    fillRight(matrix, num, 0, 0);

    return ;
    function fillDown(matrix, num, row, col) {
        for (var r = row; r < rows; r++) {
            if(isInMatrix(matrix, r, col - 1)){

                if(matrix[r][col] === 0){
                    matrix[r][col] = num++;
                    count--;
                }
                if(isInMatrix(matrix, r+1, col)){
                    if(matrix[r + 1][col] !== 0){
                        r++;
                        break;
                    }
                }
            }
        }
        fillLeft(matrix,num, r - 1, col - 1);
    }

    function fillLeft(matrix, num, row, col) {
        let r = row;
        for (var c = col; c >= 0; c--) {
            if(isInMatrix(matrix, row, c)){

                if(0 === matrix[row][c]){
                    matrix[row][c] = num++;
                    count--;
                }
                if(isInMatrix(matrix, r, c - 1)){

                    if(matrix[r][c - 1] !== 0){
                        c--;
                        break;
                    }
                }
            }
        }

        fillUp(matrix, num, r, c + 1);
    }

    function fillUp(matrix, num, row, col) {
        for (var r = row; r >= 0; r--) {
            if(isInMatrix(matrix, r, col)){

                if(0 ===matrix[r][col]){
                    matrix[r][col] = num++;
                    count--;
                }
                if(isInMatrix(matrix, r - 1, col)){

                    if(matrix[r -1][col] !== 0){
                        r++;
                        break;
                    }
                }

            }
        }
        fillRight(matrix, num, r - 1, col)
    }

    function fillRight(matrix, num, row, col) {
        row = iter++;
        if(count === 0){
            isFull = true;
        }
        if(isFull){
            printMatrix(matrix);
            return;
        }
        for (var c = col; c < cols; c++) {
            if(isInMatrix(matrix, row, c)){

                if(0 === matrix[c][row]){
                    matrix[row][c] = num++;
                    count--;
                }

                if(isInMatrix(matrix, row, c + 1)){
                    if(matrix[row][c + 1] !== 0){
                        c++;
                        break;
                    }
                }
            }
        }

        fillDown(matrix, num, row, c - 1);
    }

    function isInMatrix(matrix, row, col) {
        return 0 <= row && row < matrix.length && 0 <= col && col < matrix[row].length;
    }


    function printMatrix(matrix) {
        for (let row = 0; row < rows; row++) {
            console.log(matrix[row].join(' '));
        }
    }

}
fillSpiralMatrix(5, 5);

