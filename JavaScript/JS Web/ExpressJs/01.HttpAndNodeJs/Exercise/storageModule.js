let storage = (() => {
    let data = {};
    let fs = require('fs');

    function put(key, value) {
        if (typeof (key) !== 'string') {
            throw new Error('Key must be a string!');
        }

        if (storage.hasOwnProperty(key)) {
            throw new Error('Property already exists!');
        }

        data[key] = value;
    }

    function get(key) {
        if (typeof (key) !== 'string') {
            throw new Error('Key muust be a string!');
        }

        if (!data.hasOwnProperty(key)) {
            throw new Error('Storage does not contain this item!');
        }

        return data[key];
    }

    function getAll() {
        if (Object.keys(data).length === 0) {
            return ('No items in storage!');

        }

        return data;
    }

    function update(key, newValue) {
        if (typeof (key) !== 'string') {
            throw new Error('Item name must be string!');
        }

        if (!data.hasOwnProperty(key)) {
            throw new Error('Storage does not contain this item!');
        }

        data[key] = newValue;
    }

    function deleteItem(key) {
        if (typeof (key) !== 'string') {
            throw new Error('Item name must be string!');
        }

        if (!data.hasOwnProperty(key)) {
            throw new Error('Storage does not contain this item!');
        }

        delete data[key];
    }

    function clear() {
        data = {};
    }

    // function save() {
    //     fs.writeFileSync('./storage.json', JSON.stringify(data));
    // }

    // function load() {
    //     let newData = fs.readFileSync('./storage.json', 'utf8')
    //     data = JSON.parse(newData);
    // }

    function save() {
        fs.writeFile('./storage.json', JSON.stringify(data), function (err) {
            if (err) {
                return;
            }
        });
    }

    function load(callback) {
     fs.readFile('./storage.json', 'utf8', function (err, newData) {
            if (err) {
                return;
            }

            data = JSON.parse(newData);
            console.log(callback());
        });
    }

    return {
        put,
        get,
        getAll,
        update,
        delete: deleteItem,
        clear,
        save,
        load
    }
})();

module.exports = { storage };