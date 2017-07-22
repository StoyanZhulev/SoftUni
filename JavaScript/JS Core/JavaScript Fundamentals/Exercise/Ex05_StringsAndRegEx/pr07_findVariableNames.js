function extractVariables(str) {
    let regex = /_([a-zA-Z0-9]+)/g;

    let match = regex.exec(str);
    let names = [];
    while (match !== null){
        names.push(match[1]);
        match = regex.exec(str);
    }

    return names.join(',');
}

console.log(extractVariables('The _id and _age variables are both integers.'));