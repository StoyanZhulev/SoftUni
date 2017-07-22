function showInfo() {
    let summary = {};
    for (let i = 0; i < arguments.length; i++) {
        let obj = arguments[i];
        let type = typeof obj;
        console.log(type + ': ' + obj);
        if(!summary[type]){
            summary[type] = 1;
        }else{
            summary[type]++;
        }
    }

    let sorted = [];
    for (let currType in summary) {
        sorted.push([currType, summary[currType]]);
    }
    sorted.sort((a, b) => Number(b[1]) - Number(a[1])).forEach(e => console.log(e[0] + " = " + e[1]));
}


showInfo('cat', 42, function () { console.log('Hello world!'); });