class TrainingCourse{
    constructor(title, trainer){
        this.title = title;
        this.trainer = trainer;
        this.topics = [];
    }

    addTopic(title, date){
        let topic = {
            title: title,
            date: new Date(date)
        };

        this.topics.push(topic);
        this.topics.sort((a, b) => a.date - b.date);
    }

    get firstTopic(){
        return this.topics[0];
    }

    get lastTopic(){
        return this.topics[this.topics.length - 1];
    }

    toString(){
        let out = `Course "${this.title}" by ${this.trainer}`;
        if(this.topics.length > 0){
            for (let topic of this.topics) {
                out += `\n * ${topic.title} - ${topic.date}`
            }
        }else{
            out += '\n'
        }

        return out;
    }
}