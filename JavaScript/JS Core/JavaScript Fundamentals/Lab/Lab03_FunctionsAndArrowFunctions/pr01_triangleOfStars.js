function drawTriangle(size){
    function drawStars(count){
        console.log('*'.repeat(count));
    }

    for (let i = 1; i <= size; i++) {
        drawStars(i);
    }

    for (let i = size - 1; i >= 1; i--) {
        drawStars(i);
    }
}


drawTriangle(5);