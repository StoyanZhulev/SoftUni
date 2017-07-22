function sumByTown(arr) {
    let towns = {};

    for (let i = 0; i < arr.length - 1; i+=2) {
        let name = arr[i];
        let pop = Number(arr[i + 1]);
        if(!towns.hasOwnProperty(name)){
            towns[name] = 0;
        }

        towns[name] += pop;
    }

    return JSON.stringify(towns);
}


console.log(sumByTown(['Sofia',
    '20',
    'Varna',
    '3',
    'Sofia',
    '5',
    'Varna',
    '4'
]));