$(() => {
    const baseUrl = 'https://phonebook-4c404.firebaseio.com/phonebook';
    const contacts = $('#phonebook');
    $('#btnLoad').on('click',loadContacts);
    $('#btnCreate').click(createContact);

    function createContact() {
        let name = $('#person').val();
        let phone = $('#phone').val();

        if(name.length === 0){
            notify('Name cannot be empty', 'error');
            return;
        }
        if(phone.length === 0){
            notify('Phone cannot be empty', 'error');
            return;
        }
        $('#btnCreate').prop('disabled', true);
        let contact = {
            name,
            phone
        };

        let req = {
            url: baseUrl + '.json',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(contact),
            success: () => {
                $('#person').val('');
                $('#phone').val('');
                notify('New contact created', 'success');
                loadContacts();

            },
            error: showError,
            complete: () => $('#btnCreate').prop('disabled', false)
        };

        $.ajax(req);
    }

     function loadContacts() {
         let req = {
             url: baseUrl + '.json',
             method: 'GET',
             success: showContacts,
             error: showError
         };
         $.ajax(req);
     }

    function showContacts(data) {
        contacts.empty();

        if(data === null){
            contacts.append($('<li>No contacts in the phonebook.</li>'))
        }
        for (let cont in data) {
            let contact = data[cont];
            let li = $(`<li><span>${contact.name}: ${contact.phone}</span> </li>`);
            li.append($('<button>[Delete]</button>').click(() => deleteContact(cont, data)));
            contacts.append(li);
        }
    }

    function showError(error) {
        contacts.empty();
        contacts.append($(`<li>Error: ${error.statusText}</li>`));

    }

    function deleteContact(cont, data) {
        let name = data[cont].name;
        let req = {
            url: baseUrl + `/${cont}.json`,
            method: 'DELETE',
            success: () => {
                notify(`Deleted ${name}`, 'info')
                loadContacts();
            },
            error: showError
        };

        $.ajax(req);
    }

    function notify(message, type) {
        let toast = document.getElementById('notification');
        toast.textContent = message;
        toast.style.display = 'block';
        switch (type){
            case 'error':
                toast.style.background = '#991111';
                break;
            case 'info':
                toast.style.background = '#111199';
                break;
            case 'success':
                toast.style.background = '#119911';
                break;

        }

        setTimeout(() => toast.style.display = 'none', 2000);
    }
});