// (() => {
//     let add = (vec1, vec2) => [vec1[0] + vec2[0], vec1[1] + vec2[1]];
//     let multiply = (vec1, scalar) => [vec1[0] * scalar, vec1[1] * scalar];
//     let length = (vec1) => Math.sqrt(Math.pow(vec1[0], 2) + Math.pow(vec1[1], 2));
//     let dot = (vec1, vec2) => vec1[0] * vec2[0] + vec1[1] * vec2[1];
//     let cross = (vec1, vec2) => vec1[0] * vec2[1] - vec1[1] * vec2[0];
//     let mathVector = {add, multiply, length, dot, cross};
//
//     return mathVector;
// })();

(function vectorMath() {
    function add(vec1, vec2) {
        return [vec1[0] + vec2[0], vec1[1] + vec2[1]];
    }

    function multiply(vec1, vec2) {
        return [vec1[0] * vec2, vec1[1] * vec2];
    }

    function length(vec) {
        return Math.sqrt(vec[0] * vec[0] + vec[1] * vec[1]);
    }

    function dot(vec1, vec2) {
        return (vec1[0] * vec2[0]) + (vec1[1] * vec2[1]);
    }

    function cross(vec1, vec2) {
        return (vec1[0] * vec2[1]) - (vec1[1] * vec2[0]);
    }

    return {
        add: add,
        multiply: multiply,
        length: length,
        dot: dot,
        cross: cross
    }
})();

let solution = vectorMath();
console.log(solution.add([1, 1], [1, 0]));
console.log(solution.multiply([3.5, -2], 2));
console.log(solution.length([3, -4]));
console.log(solution.dot([1, 0], [0, -1]));
console.log(solution.cross([3, 7], [1, 0]));

// function add(vec1, vec2) {
//     let result = [];
//     function sum(a, b) {
//         return Number(a) + Number(b);
//     }
//     let vec1Sum = sum.apply(null, vec1);
//     let vec2Sum = sum.apply(null, vec2);
//     result.push(vec1Sum);
//     result.push(vec2Sum);
//     return result;
// }