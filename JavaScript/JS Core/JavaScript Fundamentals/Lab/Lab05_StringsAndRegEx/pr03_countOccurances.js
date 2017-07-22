function countOccurances(str, text) {
    let index = text.indexOf(str);
    let count = 0;
    while (index >= 0){
        count ++;
        index = text.indexOf(str, index +1);
    }

    return count;
}

console.log(countOccurances('haha', 'hahaha'));