function orderRects(rectangles) {
    let rects = [];
    for (let rec of rectangles) {
        let width = rec[0];
        let height = rec[1];
        let rectangle = {
            width: width,
            height: height,
            area: function () {
                return this.width * 2 + this.height * 2;
            },
            compareTo: function (other) {
                let result = this.area() - other.area();
                return result || this.width - other.width;
            }
        };
        rects.push(rectangle);
    }

    return rects.sort((a, b) => b.compareTo(a));
}

orderRects([[10,5],[5,12]]);