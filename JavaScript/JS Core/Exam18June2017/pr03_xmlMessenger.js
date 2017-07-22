function makeHtml(m) {
    let messageRegex = /^<message\s+([a-z]+="[\w\s.]+"\s*)+>(.*|[\s\S]*)<\/message>$/gm;
    let toRegex = /\bto="([\w\s.]+)"/g;
    let fromRegex = /\bfrom="([\w\s.]+)"/g;


    if(m.match(messageRegex)){
        let hasTo = toRegex.exec(m);
        let hasFrom = fromRegex.exec(m);
        if(hasTo === null){
            return 'Missing attributes';
        }
        if(hasFrom === null){
            return 'Missing attributes';
        }

        let message = messageRegex.exec(m);
        let mess = message[2];
        let messegeArr = mess.split('\n').filter(e => e!== '');
        let to = hasTo[1];
        let from = hasFrom[1];

        let result = '<article>\n';
        result += `  <div>From: <span class="sender">${from}</span></div>\n`;
        result += `  <div>To: <span class="recipient">${to}</span></div>\n`;
        result += '  <div>\n';
        for (let me of messegeArr) {
            result += `    <p>${me}</p>\n`;
        }

        result += '  </div>\n';
        result += '</article>';
        return result;
    }

    return 'Invalid message format';
}


console.log(makeHtml(`<message from="Alice" timestamp="1497254112">This is a test</message>
`));