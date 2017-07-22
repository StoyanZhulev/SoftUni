function rotateArray(arr) {
    let count = Number(arr.pop());
    count %= arr.length;
    for (let i = 0; i < count; i++) {
        arr.unshift(arr.pop());
    }

    return arr.join(' ');
}

