function findBiggestNum(nums) {
    let biggest = nums[0];

    for (let i = 0; i < nums.length; i++) {
        if(nums[i] > biggest){
            biggest = nums[i];
        }
    }

    return biggest;
}