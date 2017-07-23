class Contact{
    constructor(firstName, lastName, phone, email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.online = false;

    }


    render(id) {
        let article = $('<article>');
        let titleDiv = $('<div>')
            .addClass('title')
            .text(`${this.firstName} ${this.lastName}`);
        if(this.online){
            $(titleDiv).addClass('online');
        }
        let button = $('<button>&#8505</button>').click(this.toggle.bind(this));
        $(titleDiv).append(button);

        this.title = titleDiv;
        let infoDiv = $('<div>').addClass('info').css('display', 'none');
        $(infoDiv).append($(`<span>&phone; ${this.phone}</span>`))
            .append($(`<span>&#9993; ${this.email}</span>`));

        $(article).append(titleDiv).append(infoDiv);

        $('#'+id).append(article);

    }

    toggle() {
        let articles = $('div article');
        let divs = $('article div.title').toArray();
        for (let div of divs) {
            if(div.textContent.startsWith(`${this.firstName} ${this.lastName}`)){
                $($(div).parent()).find('div.info').toggle();
            }
        }
    }
    set online(on){
        this._online = on;
        if(this.online === true){
            let divs = $('article div.title').toArray();
            for (let div of divs) {
                if(div.textContent.startsWith(`${this.firstName} ${this.lastName}`)){
                    $(div).addClass('online');
                }
            }
        }else{
            let divs = $('article div.title').toArray();
            for (let div of divs) {
                if(div.textContent.startsWith(`${this.firstName} ${this.lastName}`)){
                    $(this.title).removeClass('online');
                }
            }
        }
    }

    get online(){
        return this._online;
    }
}