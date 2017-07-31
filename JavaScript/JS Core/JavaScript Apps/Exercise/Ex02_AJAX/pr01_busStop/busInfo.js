function getInfo() {
    const buses = $('#buses');

    let stopId = $('#stopId').val();
    let req = {
        url: `https://judgetests.firebaseio.com/businfo/${stopId}.json `,
        method: 'GET',
        success: showInfo,
        error: showError
    };
    $.ajax(req);

    function showInfo(busStop) {
        let name = busStop.name;
        buses.empty();
        $('#stopName').text(name);
        let stopBuses = busStop.buses;
        for (let busId in stopBuses) {
            buses.append(`<li>Bus ${busId} arrives in ${stopBuses[busId]} minutes</li>`)
        }
    }

    function showError() {
        buses.empty();
        $('#stopName').text('Error');
    }
}