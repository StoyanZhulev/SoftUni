function findDistance([x1, y1,z1, x2, y2, z2]) {
    let poinA = {x: x1, y: y1,z: z1};
    let pointB = {x: x2, y: y2, z:z2};

    let distanceX = Math.pow(poinA.x - pointB.x, 2);
    let distanceY = Math.pow(poinA.y - pointB.y, 2);
    let distanceZ = Math.pow(poinA.z - pointB.z, 2);

    return Math.sqrt(distanceX + distanceY + distanceZ);
}