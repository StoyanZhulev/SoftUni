function roadRadar(arr) {
    let [speed, area] = arr;
    function getLimit(area) {
        switch (area){
            case 'motorway':
                return 130;
            case 'interstate':
                return 90;
            case 'city':
                return 50;
            case 'residential':
                return 20;
        }
    }

    let limit = getLimit(area);

    function getInfraction(speed, limit) {
        let diff = speed - limit;
        if(diff <= 0){
            return false;
        }else {
            if(diff <= 20){
                return 'speeding';
            }else if(diff <= 40){
                return 'excessive speeding';
            }else {
                return 'reckless driving';
            }
        }
    }

    let infraction = getInfraction(speed, limit);

    if(infraction){
        console.log(infraction);
    }
}


roadRadar([40, 'city']);
roadRadar([21, 'residential']);
roadRadar([120, 'interstate']);
roadRadar([200, 'motorway']);