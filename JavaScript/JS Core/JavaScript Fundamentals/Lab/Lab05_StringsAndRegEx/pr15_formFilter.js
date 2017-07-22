function formFiller(name, email, phone, text) {
    for (let t of text) {
        t = t.replace(/<![a-zA-Z]+!>/, name);
        t = t.replace(/<@[a-zA-Z]+@>/, email);
        t = t.replace(/<\+[a-zA-Z]+\+>/, phone);

        console.log(t);
    }
}