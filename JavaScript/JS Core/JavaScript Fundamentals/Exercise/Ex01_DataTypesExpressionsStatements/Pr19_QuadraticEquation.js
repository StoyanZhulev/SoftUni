function solveEquation(a, b, c) {

    let discr = b*b - 4*a*c;
    if(discr > 0){
        let x1 = ((-b + Math.sqrt(discr)) / (2*a));
        let x2 = ((-b - Math.sqrt(discr)) / (2*a));
       console.log(Math.min(x1, x2));
        console.log(Math.max(x1, x2));
    }else if(discr === 0){
        console.log((-b + Math.sqrt(discr)) / (2*a));
    }else{
        console.log('No');
    }

}