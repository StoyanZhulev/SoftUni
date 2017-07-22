class Player {
    constructor(nickname) {
        this.nickname = nickname;
        this.scores = [];
    }

    addScore(score) {

        if(!isNaN(parseFloat(score)) && isFinite(score)){
            this.scores.push(Number(score));
        }
        return this;
    }

    get scoreCount() {
        return this.scores.length;
    }

    get highestScore() {
        return this.scores.sort((a, b) => b -a)[0];
    }

    get topFiveScore() {
        return this.scores.sort((a, b) => b -a).slice(0, 5);
    }

    toString() {
        if (this.scores.length === 0) {
            return `${this.nickname}: []`;
        } else {
            return `${this.nickname}: [${this.scores.sort((a, b) => b - a)}]`;
        }
    }
}