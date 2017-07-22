function addAndRemove(comands) {
    let arr = [];
    let num = 1;
    for (let command of comands) {
        switch (command){
            case 'add':
                arr.push(num++);
                break;
            case 'remove':
                arr.pop();
                num++;
                break;
        }
    }

    if(arr.length === 0){
        console.log('Empty');
    }else{
        console.log(arr.join('\n'));
    }
}