function composeList(arr) {
    function replace(string) {
        let symbols = [];
        symbols['&'] = '&amp;';
        symbols['<'] = '&lt;';
        symbols['>'] = '&gt;';
        symbols['"'] = '&quot;';
        for (let s in symbols) {
            let index = string.indexOf(s);
            while(index >= 0){
                string = string.replace(s, symbols[s]);
                index = string.indexOf(s, index + 1);
            }
        }

        return string;
    }
    let result = '<ul>\n';

    for (let line of arr) {
        let l = replace(line);
        result += `  <li>${l}</li>\n`;
    }

    result += '</ul>'

    return result;
}



console.log(composeList(['<b>unescaped text</b>', 'normal text']));