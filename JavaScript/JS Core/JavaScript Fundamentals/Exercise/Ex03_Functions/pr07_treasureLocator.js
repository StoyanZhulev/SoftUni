function findLocation(nums) {
    for (let i = 0; i < nums.length - 1; i+=2) {
        let x = Number(nums[i]);
        let y = Number(nums[i + 1]);

        console.log(location(x, y));
    }

    function location(x, y) {
        if(x >= 1 && x <= 3 && y >= 1 && y <= 3){
            return 'Tuvalu';
        }else if(x >= 8 && x <= 9 && y >= 0 && y <= 1){
            return 'Tokelau';
        }else if(x >= 5 && x <= 7 && y >= 3 && y <= 6){
            return 'Samoa';
        }else if(x >= 0 && x <= 2 && y >= 6 && y <= 8){
            return 'Tonga';
        }else if(x >=4 && x <= 9 && y >= 7 && y <= 8){
            return 'Cook';
        }else {
            return 'On the bottom of the ocean';
        }
    }
}

findLocation([4, 2, 1.5, 6.5, 1, 3]);