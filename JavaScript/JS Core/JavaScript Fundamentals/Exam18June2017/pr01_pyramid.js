function calcResources(b, incr) {
    let base = Number(b);
    let increment = Number(incr);

    let gold = 0;
    let stone = 0;
    let marble = 0;
    let lapis = 0;
let steps  = 1;
    let count = 1;
    while (base > 2){
        let curr = base * base;
        let outer = 2 * base + 2 * (base - 2);
        if(count === 5){
            lapis += (outer * increment);
            count = 0;
        }else{
            marble += (outer * increment);
        }
        let stones = curr - outer;
        stone += (stones * increment);
        count++;
        base -= 2;
        steps++;
    }
    if(base === 0){
        base = 2;
        steps--;
    }
    gold = base * base * increment;


    console.log(`Stone required: ${Math.ceil(stone)}`);
    console.log(`Marble required: ${Math.ceil(marble)}`);
    console.log(`Lapis Lazuli required: ${Math.ceil(lapis)}`);
    console.log(`Gold required: ${Math.ceil(gold)}`);
    console.log(`Final pyramid height: ${Math.floor(steps * increment)}`);
}


calcResources('23','0.5');