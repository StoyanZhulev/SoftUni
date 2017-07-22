class MailBox{
    constructor(){
        this.mails = [];
    }

    addMessage(subject, text){
        this.mails.push({subject, text});
        return this
    }

    get messageCount(){
        return this.mails.length;
    }

    deleteAllMessages(){
        this.mails.length = 0;
    }

    findBySubject(substr){
        let arr = [];
        for (let mail of this.mails) {
            if(mail.subject.includes(substr)){
                arr.push(mail);
            }
        }

        return arr;
    }

    toString(){
        let out = '';
        if(this.mails.length === 0){
            out += '* (empty mailbox';
        }else{
            for (let mail of this.mails) {
                out += `* [${mail.subject}] ${mail.text}\n`
            }
        }

        return out.trim();
    }
}