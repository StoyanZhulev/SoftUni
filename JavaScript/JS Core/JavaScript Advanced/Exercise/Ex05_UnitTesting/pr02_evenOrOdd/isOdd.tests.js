let isOddOrEven = require('./isOdd').isOddOrEven;
let expect = require('../chai').expect;

describe('isOddOrEven functionality tests', function () {
    describe('Tests should return undefined', function () {
        it('with number param', function () {
            expect(isOddOrEven(13)).to.be.undefined;
        });
        it('with object param', function () {
            expect(isOddOrEven({})).to.be.undefined;
        });
    });

    describe('Tests should return even', function () {
        it('with pesh', function () {
            expect(isOddOrEven('pesh')).to.equal('even');
        });
    });

    describe('Tets should return odd', function () {
        it('with pesho', function () {
            expect(isOddOrEven('pesho')).to.equal('odd');
        });
    });
});