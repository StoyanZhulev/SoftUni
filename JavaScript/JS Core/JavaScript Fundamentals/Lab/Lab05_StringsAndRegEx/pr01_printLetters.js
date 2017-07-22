function printLetters(string) {
    for (let i in string) {
        console.log(`str[${i}] -> ${string[i]}`);
    }
}

printLetters('Hello, World');