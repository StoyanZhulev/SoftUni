function aggregateElements(elements) {
    function aggregate(elements, start, func) {
        for (let num of elements) {
            start = func(start, num);
        }

        return start;
    }

    console.log(aggregate(elements, 0, (a, b) => a + b));
    console.log(aggregate(elements, 0, (a, b) => a + 1/b));
    console.log(aggregate(elements, '', (a, b) => a + b));
}


aggregateElements([1, 2, 3]);