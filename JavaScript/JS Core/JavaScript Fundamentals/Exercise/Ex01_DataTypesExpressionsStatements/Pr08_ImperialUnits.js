function calcFeet(num) {
    let feet =num / 12;
    let inch = num % 12;

    console.log(`${Math.floor(feet)}'-${inch}"`);
}


calcFeet(11);