let makeList = require('./list');
let expect = require('chai').expect;

describe('list functionality', function () {
    let list;
    beforeEach(function () {
        list = makeList();
    });
    describe('initial tests', function () {
        it('should be a function', function () {
            expect(typeof makeLIst).to.equal('function');
        });

        it('should be a object', function () {
            expect(typeof list).to.equal('object');
        });

        it('should have property addLeft', function () {
            expect(list.hasOwnProperty('addLeft')).to.be.true;
        });

        it('should have property addRight', function () {
            expect(list.hasOwnProperty('addRight')).to.be.true;
        });

        it('should have property clear', function () {
            expect(list.hasOwnProperty('clear')).to.be.true;
        });

        it('should have property toString', function () {
            expect(list.hasOwnProperty('toString')).to.be.true;
        });
    });

    describe('addLEft tests', function () {
        it('should add num in the front', function () {
            list.addLeft(8);
            expect(list.toString()).to.equal('8');
        });

        it('should add num in the front', function () {
            list.addLeft(8);
            list.addLeft(9);
            expect(list.toString()).to.equal('9, 8');
        });

        it('should add elements in the front', function () {
            list.addLeft(8);
            list.addLeft({});
            list.addLeft('pesho');
            list.addLeft({num: 4, str: 'az'});
            expect(list.toString()).to.equal('[object Object], pesho, [object Object], 8');
        });
    });

    describe('addRight tests', function () {
        it('should add num in the front', function () {
            list.addRight(8);
            expect(list.toString()).to.equal('8');
        });

        it('should add num in the front', function () {
            list.addRight(8);
            list.addRight(9);
            expect(list.toString()).to.equal('8, 9');
        });

        it('should add elements in the front', function () {
            list.addRight(8);
            list.addRight({});
            list.addRight('pesho');
            list.addRight({num: 4, str: 'az'});
            expect(list.toString()).to.equal('8, [object Object], pesho, [object Object]');
        });
    });

    describe('clear tests', function () {
        it('should clear list', function () {
            list.addRight(9);
            expect(list.toString()).to.equal('9');
            list.clear();
            expect(list.toString()).to.equal('');
        });
    });

    it('should work ', function () {
        list.addLeft(88);
        expect(list.toString()).to.equal('88');
        list.addRight({});
        expect(list.toString()).to.equal('88, [object Object]');
        list.addLeft('pesho');
        expect(list.toString()).to.equal('pesho, 88, [object Object]');
        list.clear();
        expect(list.toString()).to.equal('');

    });
});