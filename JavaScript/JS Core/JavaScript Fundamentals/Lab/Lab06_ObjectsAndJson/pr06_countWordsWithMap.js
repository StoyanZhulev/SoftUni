function countWords(text) {
    let words = text.shift().toLowerCase().split(/\W+/i).filter(e => e !== '');
    let wordsCount = new Map();
    for (let word of words) {
        if (!wordsCount.has(word)) {
            wordsCount.set(word, 0);
        }

        wordsCount.set(word, wordsCount.get(word) + 1);
    }

    [...wordsCount.keys()].sort()
        .forEach(w => console.log(`'${w}' -> ${wordsCount.get(w)} times`)
        );

}

countWords(["Far too slow, you're far too slow."]);