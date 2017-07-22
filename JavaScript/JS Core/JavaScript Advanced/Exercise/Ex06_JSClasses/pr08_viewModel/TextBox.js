class Textbox {
    constructor(selector, regex) {
        this.value = $(selector).val();

        this._elements = $(selector);
        this._invalidSymbols = regex;

        this.onInput();
    }

    get value() {
        return this._value;
    }
    set value(value) {
        for (let e of $(this.elements)) {
            $(e).val(value);
        }

        this._value = value;
    }

    get elements() {
        return this._elements;
    }

    isValid() {
        if (this._invalidSymbols.test(this.value)) {
            return false;
        }

        return true;
    }

    onInput() {
        this.elements.on('input', (event) => {
            this.value = $(event.target).val();
        });
    }
}