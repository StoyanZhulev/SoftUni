function validateEmail(email) {
    let regex = /^[A-Za-z0-9]+@[a-z]+(\.[a-z]+)+$/g;
    let isValid = regex.test(email);
    if(isValid){
        return 'Valid';
    }

    return 'Invalid';
}

console.log(validateEmail('invalid@emai1.bg'));