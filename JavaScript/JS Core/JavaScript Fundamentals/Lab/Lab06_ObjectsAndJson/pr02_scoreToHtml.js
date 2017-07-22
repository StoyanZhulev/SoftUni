function parseScore(json) {
    let obj = JSON.parse(json);
    let html = "<table>\n";
    html += '  <tr><th>name</th><th>score</th></tr>\n';
    for (let o of obj) {
        html += `  <tr><td>${escapeHtml(o.name)}</td><td>${o.score}</td></tr>\n`
    }
    html += '</table>';
    function escapeHtml (html) {
        html = html.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;").replace(/'/g, "&#39;");
        return html;
    }

    return html;
}