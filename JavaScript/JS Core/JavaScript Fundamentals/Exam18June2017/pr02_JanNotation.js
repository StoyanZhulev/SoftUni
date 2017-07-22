function solve(arr) {
    let nums = [];

    for (let obj of arr) {
        if(obj !== '+' && obj !== '-' && obj !== '*' && obj !== '/'){
            nums.push(Number(obj));
        }else{
            let first = 0;
            let second = 0;

            if(nums.length >= 2){
                switch (obj){
                    case '+':
                        second = nums.pop();
                        first = nums.pop();
                        nums.push(first + second);
                        break;
                    case '-':
                        second = nums.pop();
                        first = nums.pop();
                        let num = first - second;
                        nums.push(num);
                        break;
                    case '/':
                        second = nums.pop();
                        first = nums.pop();
                        nums.push(first / second);
                        break;
                    case '*':
                        second = nums.pop();
                        first = nums.pop();
                        nums.push(first * second);
                        break;
                }
            }else{
                return ('Error: not enough operands!');
            }
        }
    }
    
    if(nums.length > 1){
        return 'Error: too many operands!';
    }else{
        return nums[0];
    }
}

console.log(solve([-1,
    1,
    '+',
    101,
    '*',
    18,
    '+',
    3,
    '/']
));