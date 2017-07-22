function getSummary(selector) {
    $(selector).click(showSummary);


    function showSummary() {
        let summaryText = $('#content strong').text();

        let summary = $('<div>');
        summary.attr('id', 'summary');
        let paragr = $('<p>');
        paragr.text(summaryText);
        summary.append($('<h2>Summary</h2>'));
        summary.append(paragr);
        $('#content').parent().append(summary);
    }
}