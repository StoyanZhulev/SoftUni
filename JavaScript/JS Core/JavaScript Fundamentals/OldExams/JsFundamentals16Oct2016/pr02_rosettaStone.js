function decript(arr) {
    let n = Number(arr.shift());
    let alphabet = [];
    alphabet.push(' ');
    for (let i = 65; i <= 90; i++) {
        alphabet.push(String.fromCharCode(i));
    }


    let template = [];
    for (let i = 0; i < n; i++) {
        template[i] = arr.shift().split(' ').filter(e => e !== '').map(Number);
    }

    let matrix = [];
    for (let i = 0; i < arr.length; i++) {
        matrix[i] = arr[i].split(' ').filter(e => e!== '').map(Number);
    }

    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            matrix[row][col] = matrix[row][col] + template[row % template.length][col % template[row % template.length].length];
        }
    }

    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            matrix[row][col] = alphabet[matrix[row][col] % 27];
        }
    }

    let result = '';

    for (let row = 0; row < matrix.length; row++) {
        //for (let col = 0; col < matrix[row].length; col++) {
            //result += matrix[row][col];
            matrix[row] = matrix[row].join('');
        //}
    }

    let res = [...matrix].join('');

    return res;
}


console.log(decript(['2',
    '59 36',
    '82 52',
    '4 18 25 19 8',
    '4 2 8 2 18',
    '23 14 22 0 22',
    '2 17 13 19 20',
    '0 9 0 22 22']
));