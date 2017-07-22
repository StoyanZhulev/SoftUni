function calcSumAndVat(nums){
    let sum = 0;
    for (num of nums){
        sum += num;
    }

    let vat = sum * 0.2;
    let total = sum * 1.2;

    console.log(`sum = ${sum.toFixed(2)}`);
    console.log(`VAT = ${vat.toFixed(2)}`);
    console.log(`total = ${total.toFixed(2)}`);
}

calcSumAndVat([1.20, 2.60, 3.50]);
