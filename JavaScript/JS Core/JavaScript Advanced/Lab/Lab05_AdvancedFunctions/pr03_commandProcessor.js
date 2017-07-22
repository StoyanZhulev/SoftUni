function processCommand(arr) {
    let result = '';

    for (let cmd of arr) {
        process(cmd);
    }

    function process(cmd) {
        let cmdArgs = cmd.split(' ');
        let command = cmdArgs[0];
        switch (command){
            case 'append':
                result +=  cmdArgs[1];
                break;
            case 'removeStart':
                result = result.slice(Number(cmdArgs[1]));
                break;
            case 'removeEnd':
                result = result.slice(0, result.length - cmdArgs[1]);
                break;
            case 'print':
                console.log(result);
                break;
        }
    }
}

processCommand(['append hello',
    'append again',
    'removeStart 3',
    'removeEnd 4',
    'print']
);
processCommand(['append 123',
    'append 45',
    'removeStart 2',
    'removeEnd 1',
    'print']
);
//(function solve() {
//      return function processCommand(arr) {
//         let result = '';
//
//         for (let cmd of arr) {
//             process(cmd);
//         }
//
//         function process(cmd) {
//             let cmdArgs = cmd.split(' ');
//             let command = cmdArgs[0];
//             switch (command){
//                 case 'append':
//                     result +=  cmdArgs[1];
//                     break;
//                 case 'removeStart':
//                     result = result.slice(Number(cmdArgs[1]));
//                     break;
//                 case 'removeEnd':
//                     result = result.slice(0, result.length - cmdArgs[1]);
//                     break;
//                 case 'print':
//                     console.log(result);
//                     break;
//             }
//         }
//     }
// })();