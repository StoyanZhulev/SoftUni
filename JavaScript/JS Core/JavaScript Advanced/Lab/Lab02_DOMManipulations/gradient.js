function attachGradientEvents() {
    let gradient = document.getElementById('gradient');
    let result = document.getElementById('result');
    gradient.addEventListener('mousemove', showPercent);
    gradient.addEventListener('mouseout', function () {
        result.textContent = '';
    });


    function showPercent(event) {
        let perc = Math.trunc((event.offsetX / (event.target.clientWidth - 1)) * 100) + '%';
        result.textContent = perc;
    }
}