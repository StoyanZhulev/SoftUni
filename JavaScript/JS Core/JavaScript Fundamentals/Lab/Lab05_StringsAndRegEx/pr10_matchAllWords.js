function findWords(text) {
    // if (Array.isArray(text)){
    //     text = text[0];
    // }
    let regex = /\w+/g;
    let words = text.match(regex);
    console.log(words.join('\|'));
}

(findWords('nqma takava durjava'));