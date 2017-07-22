function isPointIn([x, y, minX, maxX, minY, maxY]) {
    if(minX <= x && x<= maxX && minY <= y && y <=maxY){
        return "inside";
    }else{
        return "outside";
    }
}

console.log(isPointIn([8, -1, 2, 12, -3, 3]));