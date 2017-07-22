function validityChek(arr) {
    let[x1, y1, x2, y2] = arr;
    let pointA = {x: x1, y: y1};
    let pointB = {x: x2, y: y2};
    let pointZero = {x: 0, y: 0};
    function findDistance(pointA, pointB) {
        let distanceX = Math.pow(pointA.x - pointB.x, 2);
        let distanceY = Math.pow(pointA.y - pointB.y, 2);

        let result = Math.sqrt(distanceX + distanceY);

        if(result * 10 %10 === 0){
            console.log(`{${pointA.x}, ${pointA.y}} to {${pointB.x}, ${pointB.y}} is valid`);
        }else{
            console.log(`{${pointA.x}, ${pointA.y}} to {${pointB.x}, ${pointB.y}} is invalid`);

        }
    }

    findDistance(pointA, pointZero);
    findDistance(pointB, pointZero);
    findDistance(pointA, pointB);
}

validityChek([2,1,1,1]);
