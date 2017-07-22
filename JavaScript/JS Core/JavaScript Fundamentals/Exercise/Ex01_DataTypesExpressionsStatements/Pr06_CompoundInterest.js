function calcInterest([sum, rate, freq, length]) {
    let interest = sum * Math.pow(1 + rate/(100 * (12/freq)), 12/freq * length);

    return interest.toFixed(2);
}

console.log(calcInterest([1500, 4.3, 3, 6]));