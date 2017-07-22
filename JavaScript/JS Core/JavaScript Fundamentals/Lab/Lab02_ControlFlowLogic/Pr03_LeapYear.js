function findLeapYear(year) {
    if((year % 4 === 0 && year % 100 !== 0) || year % 400 === 0){
        console.log("yes");
    }else{
        console.log("no");
    }
}

findLeapYear(1999);
findLeapYear(2000);
findLeapYear(1900);