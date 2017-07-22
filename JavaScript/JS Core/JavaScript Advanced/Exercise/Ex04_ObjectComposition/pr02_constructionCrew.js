function drunkWorker(worker) {
    if(worker.handsShaking === true){
        let alc = Number(worker.experience) * 0.1;
        worker.bloodAlcoholLevel += alc * worker.weight;
        worker.handsShaking = false;
    }

    return worker;
}

console.log(drunkWorker({ weight: 95,
    experience: 3,
    bloodAlcoholLevel: 0,
    handsShaking: false }

));