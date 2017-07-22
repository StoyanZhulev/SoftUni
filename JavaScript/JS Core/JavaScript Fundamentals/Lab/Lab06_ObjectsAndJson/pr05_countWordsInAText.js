function countWords(text) {
    let words = text.shift().split(/\W+/).filter(e => e!== '');
    let wordsCount = {};

    for (let word of words) {
        if(!wordsCount.hasOwnProperty(word)){
            wordsCount[word] = 0;
        }

        wordsCount[word]++;
    }


    return JSON.stringify(wordsCount);
}

console.log(countWords("Far too slow, you're far too slow."));