let Sumator = require('./sumator');
let expect = require('chai').expect;


describe('Sumator tests', function () {

    let sumator;
    beforeEach('initialize list', function () {
        sumator = new Sumator();

    });
    describe('initialization tests', function () {
        it('sorted list to be class', function () {
            sumator = new Sumator();
            expect(typeof sumator).to.equal('object');
        });

        it('should have property add', function () {
            expect(Sumator.prototype.hasOwnProperty('add')).to.be.true;
        });
        it('should have property sumNums', function () {
            expect(Sumator.prototype.hasOwnProperty('sumNums')).to.be.true;
        });
        it('should have property removeByFilter', function () {
            expect(Sumator.prototype.hasOwnProperty('removeByFilter')).to.be.true;
        });
        it('should have property toString', function () {
            expect(Sumator.prototype.hasOwnProperty('toString')).to.be.true;
        });

        it('should have prop data', function () {
           expect(sumator.hasOwnProperty('data')).to.be.true;
        });
        it('should have empty data', function () {
            expect(sumator.toString()).to.equal('(empty)');
        });
    });

    describe('add function tests', function () {
       it('should add numbers', function () {
          sumator.add(2);
          expect(sumator.toString()).to.equal('2');
       });

        it('should add floating point numbers', function () {
            sumator.add(2.4);
            expect(sumator.toString()).to.equal('2.4');
        });

       it('should add strings', function () {
          sumator.add('gosho');
           expect(sumator.toString()).to.equal('gosho');
       });

        it('should add obj', function () {
            sumator.add({name: 'ivan'});
            expect(sumator.toString()).to.equal('[object Object]');
        });



        it('should add elements', function () {
            sumator.add('gosho');
            sumator.add(5);
            sumator.add({});
            sumator.add('ivan');
            expect(sumator.toString()).to.equal('gosho, 5, [object Object], ivan');
        });
    });

    describe('sumNums function tests', function () {
            it('should return 0 if no nums', function () {
               sumator.add('asd');
               sumator.add('asd');
               sumator.add('asd');
               sumator.add('asd');
               expect(sumator.sumNums()).to.equal(0);
            });

        it('should return 0 if empty data', function () {
            expect(sumator.sumNums()).to.equal(0);
        });
        it('should return sum', function () {
            sumator.add('asd');
            sumator.add(7);
            sumator.add(0.5);
            sumator.add(7);
            expect(sumator.sumNums()).to.equal(14.5);
        });
    });


    describe('removeByFilter tests', function () {
       it('should not remove if no matches', function () {
           sumator.add(5);
           sumator.add(5);
           sumator.add(5);
           sumator.add(5);
           sumator.removeByFilter(x => x % 2 === 0);
           expect(sumator.toString()).to.equal('5, 5, 5, 5');
       });

        it('should not remove if empty', function () {
           expect(sumator.toString()).to.equal('(empty)');
        });

        it('should remove', function () {
            sumator.add(5);
            sumator.add(6);
            sumator.add(5);
            sumator.add(8);
            expect(sumator.toString()).to.equal('5, 6, 5, 8');

            sumator.removeByFilter(x => x % 2 === 0);
            expect(sumator.toString()).to.equal('5, 5');
        });
    });
});