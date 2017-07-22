function drawSquare(size = 5) {
    function drawStars(size) {
        console.log('*' + ' *'.repeat(size - 1));
    }

    for (let i = 1; i <= size; i++) {
        drawStars(size);
    }
}


drawSquare();