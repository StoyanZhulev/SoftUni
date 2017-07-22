class SortedList {
    constructor() {
        this._elements = [];
        this.size = 0;
    }

    add(element) {
        this._elements.push(element);
        this._elements = this._elements.sort(function (e1, e2) {
            return e1 - e2;
        });

        this.size++;
    }

    remove(index) {
        this.validate(index);
        let newElements = [];
        for (let i = 0; i < this._elements.length; i++) {
            if (i !== index) {
                newElements.push(this._elements[i]);
            }
        }

        this._elements = newElements;
        this.size--;
    }

    get(index) {
        this.validate(index);

        return this._elements[index];
    }

    validate(index) {
        if (index < 0 || index >= this._elements.length) {
            throw new Error("Invalid Index");
        }
    }
}