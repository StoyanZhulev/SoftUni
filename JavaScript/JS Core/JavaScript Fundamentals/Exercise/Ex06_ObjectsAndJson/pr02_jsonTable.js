function makeTable(json) {

    let html = '<table>\n';
    for (let obj of json) {
        let empl = JSON.parse(obj);
        html += '    <tr>\n';
        html += `        <td>${escapeHtml(empl.name)}</td>\n`
        html += `        <td>${escapeHtml(empl.position)}</td>\n`
        html += `        <td>${Number(empl.salary)}</td>\n`;
        html += '    <tr>\n';

    }

    html += '</table>\n';

    return html;

    function escapeHtml(html) {
        html = html.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;").replace(/'/g, "&#39;");
        return html;
    }
}

console.log(makeTable(['{"name":"Pesho","position":"Promenliva","salary":100000}',
    '{"name":"Teo","position":"Lecturer","salary":1000}',
    '{"name":"Georgi","position":"Lecturer","salary":1000}']
));