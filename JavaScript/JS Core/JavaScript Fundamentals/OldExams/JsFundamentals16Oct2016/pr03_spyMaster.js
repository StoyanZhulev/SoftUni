function decriptMessage(arr) {
    let specialKey = arr.shift();
    let specialKeyChars = "";
    for(let char of specialKey){
        specialKeyChars += `[${char.toUpperCase()}${char.toLowerCase()}]`;
    }

    let pattern = "(^| )(" + specialKeyChars + "\\s+)([A-Z!%\\$#]{8,})( |\\.|,|$)";
    let regex =new RegExp(pattern, "g");

    for (let line of arr) {
        let match = regex.exec(line);
        while (match !== null){
            let decodedMessage = match[3].toLowerCase().replace(/!/g, "1").replace(/%/g, "2").replace(/#/g, "3").replace(/\$/g, "4");
            line = line.replace(match[0], match[1] + match[2] +decodedMessage + match[4]);
            match = regex.exec(line);
        }
        console.log(line);
    }
}


decriptMessage(['specialKey',
    'In this text the specialKey HELLOWORLD! is correct, but',
    'the following specialKey $HelloWorl#d and spEcIaLKEy HOLLOWORLD1 are not, while',
    'SpeCIaLkeY   SOM%%ETH$IN and SPECIALKEY ##$$##$$ are!'
]);