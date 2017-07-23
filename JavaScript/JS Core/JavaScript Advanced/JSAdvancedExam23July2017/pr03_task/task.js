class Task{
    constructor(title, deadline){
        this.title = title;
        this.status = 'Open';
        this.deadline = deadline;
        this.isOverdue = false;
    }

    get deadline(){
        return this._deadline;
    }

    set deadline(deadline){
        let n = Date.now();
        if(deadline.getTime() < n){
            if(this.status !== 'Complete'){
                this.isOverdue = true;
            }
            throw new Error('Deadline is in the past!');
        }
        this._deadline = deadline;
    }

    get isOverdue(){
        let n = Date.now();
        if(this._deadline.getTime() < n){
            if(this.status !== 'Complete'){
                this.isOverdue = true;
            }
        }
        return this._isOverdue;
    }

    set isOverdue(iverdue){
        this._isOverdue = iverdue;
    }

    static comparator(a, b){
        let aStatus = a.status;
        let bStatus = b.status;
        let aOverdue = a.isOverdue;
        let bOverdue = b.isOverdue;

        if(aStatus === 'Complete'){
            if(bStatus === 'Complete'){
                return a.deadline.getTime() - b.deadline.getTime();
            }else {
                return 1;
            }
        }else if(bStatus === 'Complete'){
            return -1;
        }

        if(aOverdue === true){
            if(bOverdue === true){
                return a.deadline.getTime() - b.deadline.getTime();
            }else{
                return -1;
            }
        }else if(bOverdue === true){
            return 1;
        }

        if(aStatus === 'In Progress'){
            if(bStatus === 'In Progress'){
                return a.deadline.getTime() - b.deadline.getTime();
            }else{
                return -1
            }
        }else if(bStatus === 'In Progress'){
            return 1;
        }

        if(aStatus === 'Open'){
            if(bStatus ==='Open'){
                return a.deadline.getTime() - b.deadline.getTime();
            }else{
                return 1;
            }
        }else{
            return -1;
        }

    }

    toString(){
        let icons = {
            'Open': '\u2731',
            'In Progress': '\u219D',
            'Complete': '\u2714',
            'Overdue': '\u26A0'
        };

        let status = this.status;
        let isOverdue = this.isOverdue;
        if(status === 'Complete'){
            return  `[${icons['Complete']}] ${this.title}`;
        }

        if(isOverdue === true){
            return `[${icons['Overdue']}] ${this.title} (overdue)`;
        }

        return `[${icons[status]}] ${this.title} (${this._deadline})`;
    }
}