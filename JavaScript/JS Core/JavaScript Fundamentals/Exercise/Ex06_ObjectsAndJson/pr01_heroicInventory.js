function heroesInfo(arr) {
    let heroes = [];

    for (let h of arr) {
        let herotokens = h.split(' / ');
        let name = herotokens[0];
        let level = Number(herotokens[1]);
        let items = [];
        if(herotokens.length > 2){

            items = Array.from(herotokens[2].split(', '));
        }

        let hero = {name: name, level: level, items: items};
        heroes.push(hero);
    }


    return JSON.stringify(heroes);
}

console.log(heroesInfo(['Jake / 1000 / Gauss, HolidayGrenade']));
