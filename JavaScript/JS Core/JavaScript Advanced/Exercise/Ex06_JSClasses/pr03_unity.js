class Rat{
    constructor(name){
        this.name = name;
        this.unitedRats = [];
    }



    unite(rat){
        if(rat instanceof Rat){
            this.unitedRats.push(rat);
        }
    }

    getRats(){
        return this.unitedRats;
    }

    toString(){
        let out = this.name;
        for (let r of this.unitedRats) {
            out += '\n';
            out += `##${r.name}`
        }
    }

}