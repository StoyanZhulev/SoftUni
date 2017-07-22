function figureArea(w, h, W, H){
    "use strict";
    let area1 = w*h;
    let are2 = W*H;

    let smaller = Math.min(w, W) * Math.min(h, H);

    let result = area1 + are2 - smaller;

    return result;
}

console.log(figureArea(2, 4, 5, 3));