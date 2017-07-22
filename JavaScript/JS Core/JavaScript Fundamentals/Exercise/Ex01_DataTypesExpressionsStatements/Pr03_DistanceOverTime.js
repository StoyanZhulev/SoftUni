function calcDistance(nums) {
    let v1 = Number(nums[0]);
    let v2 = Number(nums[1]);
    let time = Number(nums[2]);

    let timeInHours = time / 3600;

    let dist1 = v1 * timeInHours * 1000;
    let dist2 = v2 * timeInHours * 1000;

    console.log(Math.abs(dist1 - dist2));
}


calcDistance([11, 10, 120]);