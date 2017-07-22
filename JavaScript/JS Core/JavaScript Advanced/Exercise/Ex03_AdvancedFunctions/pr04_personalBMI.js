function personalBMI(name, age, weight, height) {
    let person = {
        name: name,
        personalInfo: {
            age: age,
            weight: weight,
            height: height
        },
        BMI: findBMI()
    };

    findStatus(person.BMI);

    function findBMI() {
        return Math.round(weight /(height * height / 10000));
    }
    function findStatus(BMI) {
        person['status'] = BMI < 18.5 ? "underweight" : BMI < 25 ? "normal" : BMI < 30 ? "overweight" : "obese";
    }

    if(person.status === 'obese'){
        addRecommendation('admission required');
    }

    function addRecommendation(rec) {
        person['recommendation'] = rec;
    }

    return person;
}

console.log(personalBMI('Peter', 29, 75, 182));