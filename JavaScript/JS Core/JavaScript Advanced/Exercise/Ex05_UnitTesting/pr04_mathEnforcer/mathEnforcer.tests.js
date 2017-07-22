let expect = require('../chai').expect;
let mathEnforcer = require('./mathEnforcer').mathEnforcer;

describe('MathEnforcer functionality tests', function () {
    describe('addFive functionality tests', function () {
        it('should return undefined when non-number passsed', function () {
            expect(mathEnforcer.addFive('pesho')).to.be.undefined;
        });

        it('should return correct value', function () {
            expect(mathEnforcer.addFive(5)).to.equal(10);
        });

        it('should return correct value with floating-point num', function () {
            expect(mathEnforcer.addFive(0.1)).to.be.closeTo(5.1, 0.01);
        });

        it('should return correct value', function () {
            expect(mathEnforcer.addFive(-5)).to.equal(0);
        });
    });

    describe('subtractTen functionality tests', function () {
        it('should return undefined when non number passed', function () {
            expect(mathEnforcer.subtractTen('men')).to.be.undefined;
        });

        it('should return correct value', function () {
            expect(mathEnforcer.subtractTen(20)).to.equal(10);
        });

        it('should return correct value with floating-point num', function () {
            expect(mathEnforcer.subtractTen(20.1)).to.be.closeTo(10.1, 0.01);
        });

        it('should return correct value', function () {
            expect(mathEnforcer.subtractTen(-10)).to.equal(-20);
        });
    });

    describe('sum functionality tests', function () {
        it('should return undefined', function () {
            expect(mathEnforcer.sum('pesho', 12)).to.be.undefined;
        });

        it('should return undefined', function () {
            expect(mathEnforcer.sum(2, 'asd')).to.be.undefined;
        });

        it('should return correct result', function () {
            expect(mathEnforcer.sum(2, 12)).to.equal(14);
        });

        it('should return correct value with floating-point num', function () {
            expect(mathEnforcer.sum(0.1, 0.1)).to.be.closeTo(0.2, 0.01);
        });

        it('should return correct result', function () {
            expect(mathEnforcer.sum(-2, -12)).to.equal(-14);
        });
    });
});