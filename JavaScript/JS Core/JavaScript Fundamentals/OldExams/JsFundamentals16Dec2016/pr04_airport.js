function getStatistics(input) {
    let planesLeft = new Set();
    let townStatistics = new Map();

    for (let line of input) {
        let lineArgs = line.split(' ');
        let planeID = lineArgs[0];
        let town = lineArgs[1];
        let passengers = Number(lineArgs[2]);
        let action = lineArgs[3];

        switch (action) {
            case "land":
                if (!planesLeft.has(planeID)) {

                    planesLeft.add(planeID);
                    if (!townStatistics.has(town)) {
                        townStatistics.set(town, {planes: new Set(), arrivals: 0, departures: 0});
                    }

                    townStatistics.get(town).planes.add(planeID);
                    townStatistics.get(town).arrivals += passengers;
                }
                break;
            case "depart":
                if(planesLeft.has(planeID)){
                    planesLeft.delete(planeID);
                    if (!townStatistics.has(town)) {
                        townStatistics.set(town, {planes: new Set(), arrivals: 0, departures: 0});
                    }
                    townStatistics.get(town).planes.add(planeID);
                    townStatistics.get(town).departures += passengers;
                }
                break;
            default:
                break;
        }
    }

    console.log("Planes left:");
    [...planesLeft].sort((a, b) => a.localeCompare(b)).forEach(e => console.log(`- ${e}`));
    [...townStatistics.keys()].sort(function (town1, town2){
        let ar1 = townStatistics.get(town1).arrivals;
        let ar2 = townStatistics.get(town2).arrivals;
        if(ar1 === ar2){
            return town1.localeCompare(town2);
        }else{
            return ar2 - ar1;
        }
    }).forEach(t => {
        let obj = townStatistics.get(t);
        console.log(t);
        console.log(`Arrivals: ${obj.arrivals}`);
        console.log(`Departures: ${obj.departures}`);
        console.log('Planes:');
        [...obj.planes].sort((p1, p2) => p1.localeCompare(p2)).forEach(p => console.log(`-- ${p}`));
    });
}


getStatistics([
    "Boeing474 Madrid 300 land",
    "AirForceOne WashingtonDC 178 land",
    "Airbus London 265 depart",
    "ATR72 WashingtonDC 272 land",
    "ATR72 Madrid 135 depart"
]);