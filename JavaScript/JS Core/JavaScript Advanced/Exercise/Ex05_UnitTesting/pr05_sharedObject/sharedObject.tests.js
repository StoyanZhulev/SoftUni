const expect = require('../chai').expect;
const jsdom = require('jsdom-global')();
const $ = require('jquery');

let sharedObject = require('./sharedObject').sharedObject;
document.body.innerHTML = `<body>
    <div id="wrapper">
        <input type="text" id="name">
        <input type="text" id="income">
    </div>
</body>
`;
describe('shared object functionality tests', function () {
    describe('initializatioin tests', function () {
        it('name should be null', function () {
            expect(sharedObject.name).to.be.null;
        });

        it('income should be null', function () {
            expect(sharedObject.income).to.be.null;
        });
    });


    describe('changeName functionality', function () {
        it('should not change name', function () {
            sharedObject.changeName('');
            expect(sharedObject.name).to.be.null;
        });

        it('should change name', function () {
            sharedObject.changeName('Stoyan');
            expect(sharedObject.name).to.equal('Stoyan');
            expect($('#name').val()).to.equal('Stoyan');
        });

        it("should return new name after calling the function more than one time", function () {
            sharedObject.changeName("Pesho");
            sharedObject.changeName("Gosho");
            expect(sharedObject.name).to.equal("Gosho");
            expect($('#name').val()).to.equal("Gosho");
        });
    });

    describe('changeIncome functionality', function () {
        it('should not change income', function () {
            sharedObject.changeIncome(-2);
            expect(sharedObject.income).to.be.null;
        });

        it('should change income', function () {
            sharedObject.changeIncome(10);
            expect(sharedObject.income).to.equal(10);
            expect($('#income').val()).to.equal('10');
        });

        it("should return previous value after calling with negative parameter", function () {
            sharedObject.changeIncome(5);
            sharedObject.changeIncome(-10);
            expect(sharedObject.income).to.equal(5);
            expect($('#income').val()).to.equal("5");
        });
    });

    describe('updateName functionality', function () {
        it('should not change name', function () {
            sharedObject.changeName('gosho');
            $('#name').val('');
            sharedObject.updateName();
            expect(sharedObject.name).to.equal('gosho');
            expect($('#name').val()).to.equal('');
        });

        it('should change name', function () {
            sharedObject.changeName('gosho');
            $('#name').val('pesho');
            sharedObject.updateName();
            expect(sharedObject.name).to.equal('pesho');
            expect($('#name').val()).to.equal('pesho');
        })
    });

    describe('updateIncome functionality', function () {
        it('should not change income', function () {
            sharedObject.changeIncome(20);
            $('#income').val('sdf');
            sharedObject.updateIncome();
            expect(sharedObject.income).to.equal(20);
            expect($('#income').val()).to.equal('sdf');
        });

        it('should change income', function () {
            sharedObject.changeIncome(30);
            $('#income').val(40);
            sharedObject.updateIncome();
            expect(sharedObject.income).to.equal(40);
            expect($('#income').val()).to.equal('40');
        })
        it("should return previous value if value is floating point number", function () {
            sharedObject.changeIncome(15);
            $("#income").val("3.6");
            sharedObject.updateIncome();
            expect(sharedObject.income).to.equal(15);
            expect($("#income").val()).to.equal("3.6");
        });

        it("should return previous value if value is negative number", function () {
            sharedObject.changeIncome(15);
            $("#income").val("-10");
            sharedObject.updateIncome();
            expect(sharedObject.income).to.equal(15);
            expect($("#income").val()).to.equal("-10");
        });

        it("should return previous value if value is 0", function () {
            sharedObject.changeIncome(15);
            $("#income").val("0");
            sharedObject.updateIncome();
            expect(sharedObject.income).to.equal(15);
            expect($("#income").val()).to.equal("0");
        });
    });
});
