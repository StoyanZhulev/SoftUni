function attachEvents() {
    let btnAdd = $('#btnAdd');
    let btnDelete = $('#btnDelete');
    let towns = $('#towns option');

    btnAdd.click(function () {
        let text = $('#newItem').val();

        if(text !== ''){
            let option = $('<option>').text(text);
            $('#towns').append(option);
        }
        $('#newItem').val('');
    });

    btnDelete.click(function () {
        if($('#towns option:selected')){
            $('#towns option:selected').remove();
        }

        $('#newItem').val('');
    });
}