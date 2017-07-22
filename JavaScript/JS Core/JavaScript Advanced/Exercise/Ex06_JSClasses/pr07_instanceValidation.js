class ChekingAccount{
    constructor(clientId, email, firstName, lastName){
        this.clientId = clientId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    set clientId(clientId){
        if(clientId.length !== 6){
            throw new TypeError('Client ID must be a 6-digit number');
        }

        this._clientId = clientId;
    }

    set email(email){
        let pattern = /\w+@[a-zA-Z.]+/;
        if(!pattern.test(email)){
            throw new TypeError('Invalid e-mail');
        }

        this._email = email;
    }

    set firstName(firstName){
        if(firstName.length <3 || firstName.length > 20){
            throw new TypeError('First name must be between 3 and 20 characters long');
        }

        if(!/[a-zA-Z]+/.test(firstName)){
            throw new TypeError('First name must contain only Latin characters');
        }

        this._firstName = firstName;
    }

    set lastName(lastName){
        if(lastName.length <3 || lastName.length > 20){
            throw new TypeError('Last name must be between 3 and 20 characters long');
        }

        if(!/[a-zA-Z]+/.test(lastName)){
            throw new TypeError('Last name must contain only Latin characters');
        }

        this._lastName = lastName;
    }
}