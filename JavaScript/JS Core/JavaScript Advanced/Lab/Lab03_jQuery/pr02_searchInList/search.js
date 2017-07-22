function search() {
    let town = $('#searchText').val();
    let matchedTowns = $(`ul#towns li:contains(${town})`);
    matchedTowns.css('font-weight', 'bold');
    $(`#towns`).find(`li:not(:contains(${town}))`).css('font-weight', '');
    $('#searchText').val('');
    $('#result').text(`${matchedTowns.length} matches found.`)
}