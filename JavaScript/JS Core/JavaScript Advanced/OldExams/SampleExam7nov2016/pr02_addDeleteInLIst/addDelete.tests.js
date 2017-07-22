let expect = require('chai').expect;
let list = require('./addDelete');
describe('addDelete functionality tests', function () {

   describe('Initial tests', function () {
      it('should be an object', function () {
          expect(typeof list).to.equal('object');
      });

      it('should have property add', function () {
         expect(list.hasOwnProperty('add')).to.be.true;
      });

       it('should have property delete', function () {
           expect(list.hasOwnProperty('delete')).to.be.true;
       });

       it('should have property toString', function () {
           expect(list.hasOwnProperty('toString')).to.be.true;
       });
   });

   describe('add function tests', function () {
       it('should add element', function () {
          list.add('added');
          expect(list.toString()).to.equal('added');
       });

       it('should add more element', function () {
           list.add('added');
           list.add('some');
           list.add('text');
           expect(list.toString()).to.equal('added, some, text');
       });
   });

    describe('delete function tests', function () {
       it('should return undefined if index is not a number', function () {
           expect(list.delete('sad')).to.be.undefined;
       });

        it('should return undefined if index is an obj', function () {
            expect(list.delete({})).to.be.undefined;
        });

        it('should return undefined if index is NaN', function () {
            expect(list.delete(NaN)).to.be.undefined;
        });

        it('should return undefined if index is out of bounds', function () {
            expect(list.delete(-1)).to.be.undefined;
        });

        it('should return undefined if index is out of bounds', function () {
            expect(list.delete(20)).to.be.undefined;
        });

        it('should delete element and return it', function () {
            list.add('text');
            expect(list.delete(0)).to.equal('text');
        });
    });

    describe('delete function tests', function () {
        it('should print elements', function () {
            expect(list.toString()).to.equal('');
        });

        it('should print elements after delete', function () {
            list.add('added');
            list.add('some');
            list.add('text');
            list.delete(1);
            expect(list.toString()).to.equal('added, text');
        });

        it('should print elements after add', function () {
            list.add('again');
            expect(list.toString()).to.equal('again');
        });
    });
});