class Stringer {
    constructor(innerString, innerLength){
        this.innerString = innerString;
        this.innerLength = Number(innerLength);
    }



    increase(length){
        this.innerLength += Number(length);
    }

    decrease(length){
        this.innerLength -= Number(length);
        if(this.innerLength < 0){
            this.innerLength = 0;
        }
    }

    toString(){
        let result = this.innerString;
        if(result.length > this.innerLength){
            result = result.substr(0, this.innerLength) + '...';
        }

        return result;
    }
}