function dna(size) {
    let letters = 'ATCGTTAGGG';
    let index = 0;
    for (let i = 0; i < size; i++) {
        if(i % 4 === 0){
            console.log(`**${letters[index]}${letters[index + 1]}**`);
        } else if (i % 2 === 0) {
            console.log(`${letters[index]}----${letters[index + 1]}`)
        } else {
            console.log(`*${letters[index]}--${letters[index + 1]}*`);
        }
        index += 2;
        if (index >= letters.length) {
            index = 0;
        }
    }
}