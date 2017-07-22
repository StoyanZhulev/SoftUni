function extractText() {
    let text = $('#items li').toArray().map((el) => el.textContent).join(', ');
    $('#result').text(text);
}