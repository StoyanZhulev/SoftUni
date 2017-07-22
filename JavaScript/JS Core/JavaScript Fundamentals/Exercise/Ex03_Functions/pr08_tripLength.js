function tripLength(arr) {
    let pointA = {x: arr[0], y: arr[1], num: 1};
    let pointB = {x: arr[2], y: arr[3], num: 2};
    let pointC = {x: arr[4], y: arr[5], num: 3};

    function findDistance(pointA, pointB) {
        let distanceX = Math.pow(pointA.x - pointB.x, 2);
        let distanceY = Math.pow(pointA.y - pointB.y, 2);

        return Math.sqrt(distanceX + distanceY);
    }

    let distanceAB = findDistance(pointA, pointB);
    let distanceAC = findDistance(pointA, pointC);
    let distanceBC = findDistance(pointB, pointC);

    if ((distanceAB <= distanceAC) && (distanceAC => distanceBC)) {
        let a = distanceAB + distanceBC;
        console.log('1->2->3: ' + a);
    }
    else if ((distanceAB <= distanceBC) && (distanceAC < distanceBC)) {
        let b = distanceAC + distanceAB;
        console.log('2->1->3: ' + b);
    }
    else {
        let c = distanceBC + distanceAC;
        console.log('1->3->2: ' + c);
    }
    //  let points = [pointA, pointB, pointC];
    // points =  points.sort((a,b) =>(a.x  + a.y) - (b.x + b.y));
    //  let min = Math.min(distanceAB, distanceAC, distanceBC);
    //  let secondMin = 0;
    //  if(min === distanceAB){
    //      secondMin = Math.min(distanceAC, distanceBC);
    //  }else if(min === distanceAC){
    //      secondMin = Math.min(distanceAB, distanceBC);
    //
    //  }else {
    //      secondMin = Math.min(distanceAB, distanceAC);
    //  }
    //  let result = min + secondMin;
    //
    //  console.log(`${points[0].num}->${points[1].num}->${points[2].num}: ${result}`);

}

tripLength([-1, -2, 3.5, 0, 0, 2]);