let expect = require('chai').expect;
let createList = require('./createList');


describe('List functionality tests', function () {
   let list;
    beforeEach(function () {
       list = createList();
   }) ;

    describe('Initial tests', function () {
       it('should be a function', function () {
         expect(typeof createList).to.equal('function');
       });

        it('should be a object', function () {
            expect(typeof list).to.equal('object');
        });

        it('should has property add', function () {
            expect(list.hasOwnProperty('add')).to.be.true;
        });

        it('should has property shiftLeft', function () {
            expect(list.hasOwnProperty('shiftLeft')).to.be.true;
        });

        it('should has property shiftRight', function () {
            expect(list.hasOwnProperty('shiftRight')).to.be.true;
        });

        it('should has property swap', function () {
            expect(list.hasOwnProperty('swap')).to.be.true;
        });

        it('should has property toString', function () {
            expect(list.hasOwnProperty('toString')).to.be.true;
        });
    });

    describe('add function tests', function () {
        it('should append numbers', function () {
           list.add(5);
           expect(list.toString()).to.equal('5');
        });

        it('should append strings', function () {
            list.add('text');
            expect(list.toString()).to.equal('text');
        });

        it('should append different objects', function () {
            list.add(5);
            list.add('ivan');
            expect(list.toString()).to.equal('5, ivan');
        });
    });

    describe('shiftLeft function tests', function () {
       it('should do nothing whitout enough elements', function () {
          list.add(5);
          list.shiftLeft();
          expect(list.toString()).to.equal('5');
       });

       it('should shift left', function () {
          list.add(5);
          list.add('gosho');
          list.add(7);
          list.shiftLeft();
          expect(list.toString()).to.equal('gosho, 7, 5');
       });
    });

    describe('shiftRight function tests', function () {
        it('should do nothing whitout enough elements', function () {
            list.add(5);
            list.shiftRight();
            expect(list.toString()).to.equal('5');
        });

        it('should shift right', function () {
            list.add(5);
            list.add('gosho');
            list.add(7);
            list.shiftRight();
            expect(list.toString()).to.equal('7, 5, gosho');
        });
    });

    describe('toString function tests', function () {
       it('should return empty string upon initialization', function () {
          expect(list.toString()).to.equal('');
       });
    });

    describe('swap function tests', function () {
       it('should return false whit non-integer index1', function () {
          list.add(1);
          list.add(3);
          list.add(5);
           expect(list.swap(1.5, 2)).to.be.false;
           expect(list.toString()).to.equal('1, 3, 5');
       });
        it('should return false whit non-integer index2', function () {
            list.add(1);
            list.add(3);
            list.add(5);
            expect(list.swap(1, 2.5)).to.be.false;
            expect(list.toString()).to.equal('1, 3, 5');
        });

        it('should return false whit index1 < 0', function () {
            list.add(1);
            list.add(3);
            list.add(5);
            expect(list.swap(-2, 2)).to.be.false;
            expect(list.toString()).to.equal('1, 3, 5');
        });

        it('should return false whit index2 < 0', function () {
            list.add(1);
            list.add(3);
            list.add(5);
            expect(list.swap(1, -2)).to.be.false;
            expect(list.toString()).to.equal('1, 3, 5');
        });




        it('should return false whit index2 >= data.length', function () {
            list.add(1);
            list.add(3);
            list.add(5);
            expect(list.swap(1, 3)).to.be.false;
            expect(list.toString()).to.equal('1, 3, 5');
        });

        it('should return false whit index1 == index2', function () {
            list.add(1);
            list.add(3);
            list.add(5);
            expect(list.swap(1, 1)).to.be.false;
            expect(list.toString()).to.equal('1, 3, 5');
        });

        it('should swap elements', function () {
           list.add(1);
           list.add(2);
           list.add(3);
           list.add(4);
           expect(list.swap(1, 3)).to.be.true;
           expect(list.toString()).to.equal('1, 4, 3, 2');
        });
    });

    it('should do everything', function () {
       list.add(5);
       list.add('goshso');
       list.add({});
       list.add(8);
       list.add(9);
       list.add('stavri');

       list.shiftLeft();
       list.shiftLeft();
       list.shiftRight();
       expect(list.swap(0, 3)).to.be.true;
       expect(list.toString()).to.equal('9, [object Object], 8, goshso, stavri, 5')
    });
});