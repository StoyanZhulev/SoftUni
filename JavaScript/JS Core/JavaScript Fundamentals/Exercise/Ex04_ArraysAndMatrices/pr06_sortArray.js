function sortArray(arr) {
    function comparator(a, b) {
        if(a.length === b.length){
            return a.localeCompare(b);
        }else{
            return a.length - b.length;
        }
    }

    arr.sort((a, b) => comparator(a, b)).forEach(e => console.log(e));
}

sortArray(['alpha',
    'beta',
    'gamma'
]);