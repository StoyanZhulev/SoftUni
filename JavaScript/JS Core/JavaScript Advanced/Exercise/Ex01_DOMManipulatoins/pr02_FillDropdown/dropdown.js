function addItem() {
    let text = document.getElementById('newItemText').value;
    let val = document.getElementById('newItemValue').value;
    let m = document.getElementById('menu');

    let opt = document.createElement('option');
    opt.textContent = text;
    opt.value = val;
    m.appendChild(opt);

    document.getElementById('newItemText').value = '';
    document.getElementById('newItemValue').value = '';
}