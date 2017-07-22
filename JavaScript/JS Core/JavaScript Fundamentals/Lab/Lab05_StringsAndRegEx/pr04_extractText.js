function extractText(text) {
    let open = text.indexOf('(');
    let texts = [];
    while (open >= 0){
        let close = text.indexOf(')', open);
        if(close == -1){
            break;
        }
        texts.push(text.substring(open + 1, close));
        open = text.indexOf('(', close + 1);
    }

    return texts.join(', ');
}


console.log(extractText('Rakiya (Bulgarian brandy) is self-made liquor (alcoholic drink)'));