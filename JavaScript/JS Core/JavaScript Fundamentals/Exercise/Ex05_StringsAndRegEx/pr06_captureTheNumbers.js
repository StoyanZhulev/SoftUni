function captureNumbers(arr) {
    // let nums = [];
    //
    let regex = /\d+/g;
    let text = arr.join(' ');
    let nums = text.match(regex);
    return nums.join(' ');
    //
    // for (let str of arr) {
    //     let match = regex.exec(str);
    //     while (match !== null){
    //         nums.push(match);
    //
    //         match = regex.exec(str);
    //     }
    // }
    //
    // return nums.join(' ');
}


console.log(captureNumbers(['The300',
    'What is that?',
    'I think it’s the 3rd movie.',
    'Lets watch it at 22:45'
]));