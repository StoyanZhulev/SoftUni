function calc(num1, num2, op) {
    let calc = (num1, num2,  func) => func(num1, num2);
    let add = (a, b) => a + b;
    let subtr = (a, b) => a - b;
    let multiply = (a, b) => a *b;
    let divide = (a, b) => a / b;

    switch (op){
        case '+':
            return calc(num1, num2, add);
        case '-':
            return subtr(num1, num2);
        case '/':
            return divide(num1, num2);
        case '*':
            return multiply(num1, num2);

    }
}

console.log(calc(2, 4, '+'));