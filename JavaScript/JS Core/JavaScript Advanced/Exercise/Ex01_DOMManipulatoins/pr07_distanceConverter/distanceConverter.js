function attachEventsListeners() {
    document.getElementById('convert').addEventListener('click', convert)

    let distances = new Map();
    distances.set('km', 1000);
    distances.set('m', 1);
    distances.set('cm', 0.01);
    distances.set('mm', 0.001);
    distances.set('mi', 1609.34);
    distances.set('yrd', 0.9144);
    distances.set('ft', 0.3048);
    distances.set('in', 0.0254);

    function convert() {
        let fromDistance = Number(document.getElementById('inputDistance').value);
        let from = document.getElementById('inputUnits').value;
        fromDistance *= distances.get(from);

        let to = document.getElementById('outputUnits').value;
        fromDistance /= distances.get(to);

        document.getElementById('outputDistance').value = fromDistance;
    }
}