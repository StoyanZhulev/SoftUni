function round([num, precision]) {
    let pr = precision;
    if(pr > 15){
        pr = 15;
    }

    console.log(Number(num.toFixed(pr)));
}

round([10.5, 3]);