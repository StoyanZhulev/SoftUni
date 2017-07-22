function stringOfNumbers(num) {
    let number = Number(num);
    let result = "";
    for(let i = 1; i <= number; i++){
        result += i;
    }

    return result;
}

console.log(stringOfNumbers("11"));