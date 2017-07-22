let proccessOdd = nums => nums.filter((e, i) => i % 2 !== 0).map(e => e *= 2).reverse().join(' ');

console.log(proccessOdd([10, 15, 20, 25]));