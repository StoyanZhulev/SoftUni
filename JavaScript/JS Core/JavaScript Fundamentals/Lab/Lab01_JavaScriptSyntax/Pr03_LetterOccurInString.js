function letterOccurance(text, letter){
    "use strict";
    let count = 0;
    for(let i = 0; i < text.length; i++){
        if(text[i] === letter){
            count++;
        }
    }

    return count;
}

console.log(letterOccurance("hello", "l"));;