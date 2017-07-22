function assignProperties(prop) {
    let object = {};
    object[prop[0]] = prop[1];
    object[prop[2]] = prop[3];
    object[prop[4]] = prop[5];

    console.log(object);
}
assignProperties(['name', 'Pesho', 'age', '23', 'gender', 'male']);