function findDistance(x1, y1, x2, y2) {
    let poinA = {x: x1, y: y1};
    let pointB = {x: x2, y: y2};

    let distanceX = Math.pow(poinA.x - pointB.x, 2);
    let distanceY = Math.pow(poinA.y - pointB.y, 2);

    return Math.sqrt(distanceX + distanceY);
}