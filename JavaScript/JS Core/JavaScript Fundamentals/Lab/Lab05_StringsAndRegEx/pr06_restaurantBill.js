function calcbill(products) {
    let sum = 0;
    let bill = [];
    for (let i = 0; i < products.length; i+=2) {
        bill.push(products[i]);
        sum += Number(products[i + 1])
    }

    return `You purchased ${bill.join(', ')} for a total sum of ${sum}`;
}

console.log(calcbill(['Beer Zagorka', '2.65', 'Tripe soup', '7.80', 'Lasagna', '5.69']));