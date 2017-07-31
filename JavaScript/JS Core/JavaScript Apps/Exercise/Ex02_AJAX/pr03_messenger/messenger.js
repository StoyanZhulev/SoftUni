function attachEvents() {
    const baseUrl = 'https://messenger-7642f.firebaseio.com/messenger.json';
    const messages = $('#messages');
    $('#submit').click(sendMessage);
    $('#refresh').click(getMessages);

    function sendMessage() {
        let author = $('#author').val();
        let content = $('#content').val();

        let message = {
            author,
            content,
            timestamp: Date.now()
        };
        let req = {
            url: baseUrl,
            method: 'POST',
            data: JSON.stringify(message),
            success: appendNewMessage(message)
        };
        $.ajax(req);
    }


    function appendNewMessage(message) {
        let text = messages.val();
        text += `\n${message.author}: ${message.content}`;
        messages.val(text.trim());
        $('#content').val('')
    }

    function getMessages() {
        let req = {
            url: baseUrl,
            method: 'GET',
            success: showMessages,
        };

        $.ajax(req);
    }

    function showMessages(data) {
        let text = '';

        for (let key in data) {
            let user = data[key];
            text += `${user['author']}: ${user['content']}` + '\n';
        }

        $('#messages').text(text.trim());
    }
}