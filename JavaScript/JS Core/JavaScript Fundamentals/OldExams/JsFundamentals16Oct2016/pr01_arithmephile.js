function arithm(arr) {
    let nums = arr.filter(e => e !== '').map(Number);

    let biggest = Number.NEGATIVE_INFINITY;
    let current = 1;

    for (let i = 0; i < nums.length; i++) {
        let num = nums[i];
        if(0 <= num && num < 10){
            current = 1;
            for (let j = i + 1; j <= Math.min(nums.length,i + num); j++) {
                current *= nums[j];
            }

        }
        if(current >= biggest && current !== 1){
            biggest = current;
        }
    }

    return biggest;
}
