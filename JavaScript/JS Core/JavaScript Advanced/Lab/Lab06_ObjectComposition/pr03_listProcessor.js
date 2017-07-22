function listPr(arr) {
    let list = [];

    let listProccessor = (function () {
       function add(str) {
           list.push(str);
       }
       function remove(str) {
           list = list.filter(e => e!== str);
       }
       function print() {
           console.log(list.toString());
       }

        return {add, remove, print};
    })();

    for (let str of arr) {
        let args = str.split(' ');
       listProccessor[args[0]](args[1]);
    }
}

listPr(['add hello', 'add again', 'remove hello', 'add again', 'print']);
