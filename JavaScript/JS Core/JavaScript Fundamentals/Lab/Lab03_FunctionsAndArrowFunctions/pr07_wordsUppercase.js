function extractWords(text) {
    function extrWords(text) {
        return text.toUpperCase().split(/\W/);
    }

    let words = extrWords(text);

    words = words.filter(w => w != '');

    return words.join(', ');
}


console.log(extractWords('Hi, how are you?'));