function jsonToTable(json) {
    let parsed = JSON.parse(json);
    let keys = Object.keys(parsed[0]);

    let html = '<table>\n';
    html += '  <tr>';
    for (let key of keys) {
        html += `<th>${escapeHtml(key)}</th>`
    }
    html += '</tr>\n';


    for (let obj of parsed) {
        html += '  <tr>';
        for (let key of keys) {
            html += '<td>'
            if(/\d+/.test(obj[key])){
                html += Number(obj[key]);
            }else{
                html += escapeHtml(obj[key]);
            }
            html += '</td>'
        }
        html += '</tr>\n';
    }
    html += '</table>';

    function escapeHtml (html) {
        html = html.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;").replace(/'/g, "&#39;");
        return html;
    }
    return html;
}


console.log(jsonToTable('[{"Name":"Tomatoes & Chips","Price":2.35},{"Name":"J&B Chocolate","Price":0.96}]'));