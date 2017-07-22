function printFigure(n) {
     let size = n % 2 === 0 ? n -1 : n;
     let dashes = '-'.repeat((2*n - 1 -3) / 2);
     let spaces = ' '.repeat((2*n - 1 -3) / 2);
     console.log(`+${dashes}+${dashes}+`);
    for (let i = 0; i < size / 2 - 2; i++) {
        console.log(`|${spaces}|${spaces}|`);
    }
    console.log(`+${dashes}+${dashes}+`);
    for (let i = 0; i < size / 2 - 2; i++) {
        console.log(`|${spaces}|${spaces}|`);
    }
    console.log(`+${dashes}+${dashes}+`);
}

printFigure(7);

