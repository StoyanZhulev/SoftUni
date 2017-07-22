function extractUsername(input) {
    let names = [];
    for (let email of input) {
        let nameAndDomain = email.split('@');
        let name = nameAndDomain[0] + '.';
        let domains = nameAndDomain[1].split('.');
        for (let i = 0; i < domains.length; i++) {
            name+= domains[i][0];
        }
        names.push(name);
    }
    
    return names.join(', ');
}


console.log(extractUsername(['peshoo@gmail.com', 'todor_43@mail.dir.bg', 'foo@bar.com']));