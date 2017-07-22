let lookupChar = require('./lookupChar').lookupChar;
let expect = require('../chai').expect;


describe('LookupChar functionality tests', function () {
    it('should return undefined with a non-string first param', function () {
        expect(lookupChar(13, 0)).to.be.undefined;
    });

    it('should return undefined with non-int param', function () {
        expect(lookupChar('pesho', 'gosho')).to.be.undefined;
    });

    it('should return undefined with floating point param', function () {
        expect(lookupChar('gosho', 3.14)).to.be.undefined;
    });

    it('should return uncorrect index with an incorrect index vaue', function () {
        expect(lookupChar('gosho', 13)).to.equal('Incorrect index');
    });

    it('should return uncorrect index with an incorrect index vaue', function () {
        expect(lookupChar('gosho', -1)).to.equal('Incorrect index');
    });

    it('should return uncorrect index with an incorrect index vaue', function () {
        expect(lookupChar('gosho', 5)).to.equal('Incorrect index');
    });

    it('should return correct value', function () {
        expect(lookupChar('pesho', 0)).to.equal('p');
    });

    it('should return correct value', function () {
        expect(lookupChar('stamat', 3)).to.equal('m');
    });
});