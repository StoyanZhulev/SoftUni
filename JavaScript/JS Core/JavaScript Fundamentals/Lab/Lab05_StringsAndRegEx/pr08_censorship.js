function censor(text, words) {
    for (let word of words) {
        let index = text.indexOf(word);
        while(index >= 0){
            text = text.replace(word, '-'.repeat(word.length));
            index = text.indexOf(word, index + 1);
        }
    }

    return text;
}


console.log(censor('roses are red, violets are blue', [', violets are', 'red']));