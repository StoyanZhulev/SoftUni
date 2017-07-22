function printKElements(nums) {
    let k = nums.shift();
    console.log(nums.slice(0, k).join(' '));
    console.log(nums.slice(-k).join(' '));
}

printKElements([2, 7, 8, 9]);
