let SortedList = require('./sortedLIst');
let expect = require('chai').expect;

describe('SortedList functionality tests', function () {
    let list;
    beforeEach('initialize list', function () {
        list = new SortedList();

    });

    describe('initialization tests', function () {
        it('sorted list to be class', function () {
            list = new SortedList();
            expect(typeof list).to.equal('object');
        });

        it('should have property add', function () {
           expect(SortedList.prototype.hasOwnProperty('add')).to.be.true;
        });
        it('should have property remove', function () {
            expect(SortedList.prototype.hasOwnProperty('remove')).to.be.true;
        });
        it('should have property get', function () {
            expect(SortedList.prototype.hasOwnProperty('get')).to.be.true;
        });
        it('should have property size', function () {
            expect(SortedList.prototype.hasOwnProperty('size')).to.be.true;
        });
        it('should have property sort', function () {
            expect(SortedList.prototype.hasOwnProperty('sort')).to.be.true;
        });
        it('should have property vrfyRange', function () {
            expect(SortedList.prototype.hasOwnProperty('vrfyRange')).to.be.true;
        });


    });


   describe('add function tests', function () {

       it('should be initialized with empty arr', function () {
           list = new SortedList();
           expect(list.size).to.equal(0);
       });

       it('should add element', function () {
           list.add(4);
           expect(list.size).to.equal(1);
       });

       it('should add elements', function () {
           list.add(4);
           list.add(5);
           expect(list.size).to.equal(2);
       });

       it('should add elements more than two', function () {
           list.add(4);
           list.add(5);
           list.add(6);
           list.add(7);
           expect(list.size).to.equal(4);
       });

       it("should be sorted after adding", function() {
           list.add(5);
           expect(list.get(0)).to.equal(5, "Element wasn't added.");
           list.add(2);
           expect(list.get(0)).to.equal(2, "Collection wasn't sorted.");
           expect(list.get(1)).to.equal(5, "Collection wasn't sorted.");
       });
   });

   describe('vrfyIndex function tests', function () {
      it('should throw exception with empty list', function () {
        expect(() => list.vrfyRange(4)).to.throw(Error, 'Collection is empty.');
      });

       it('should throw exception with index < 0', function () {
          list.add(4);
          list.add(5);
           expect(() => list.vrfyRange(-1)).to.throw(Error, 'Index was outside the bounds of the collection.');
       });

       it('should throw exception with index > list.length', function () {
           list.add(4);
           list.add(5);
           expect(() => list.vrfyRange(3)).to.throw(Error, 'Index was outside the bounds of the collection.');
       });
   });

   describe('remove funtion tests', function () {
        it('should remove elements', function () {
           list.add(4);
           list.add(5);
           list.add(6);
           list.remove(1);
           expect(list.size).to.equal(2);
        });

       it('should throw exception with empty list', function () {
           expect(() => list.remove(4)).to.throw(Error);
       });

       it('should throw exception with index < 0', function () {
           list.add(4);
           list.add(5);
           expect(() => list.remove(-1)).to.throw(Error, "Index was outside the bounds of the collection.");
       });


       it('should throw exception with index > list.length', function () {
           list.add(4);
           list.add(5);
           expect(() => list.remove(3)).to.throw(Error, "Index was outside the bounds of the collection.");
       });
   });

   describe('get dunctionality tests', function () {
      it('should return first element', function () {
            list.add(5);
            expect(list.get(0)).to.equal(5);
      });

       it('should return last element', function () {
           list.add(5);
           list.add(6);
           list.add(7);
           expect(list.get(2)).to.equal(7);
       });

       it('should return any element', function () {
           list.add(5);
           list.add(6);
           list.add(7);
           expect(list.get(1)).to.equal(6);
       });

       it('should throw exception with empty list', function () {
           expect(() => list.get(4)).to.throw(Error);
       });

       it('should throw exception with index < 0', function () {
           list.add(4);
           list.add(5);
           expect(() => list.get(-1)).to.throw(Error);
       });


       it('should throw exception with index > list.length', function () {
           list.add(4);
           list.add(5);
           expect(() => list.get(3)).to.throw(Error);
       });
   });

   describe('sort function tests', function () {
      it('should sort list', function () {
         list.add(3);
         list.add(10);
         list.add(5);
         list.add(2);
         list.add(1);
         list.sort();
         expect(list.get(0)).to.equal(1);
         expect(list.get(1)).to.equal(2);
         expect(list.get(2)).to.equal(3);
         expect(list.get(3)).to.equal(5);
         expect(list.get(4)).to.equal(10);
      });
   });
});