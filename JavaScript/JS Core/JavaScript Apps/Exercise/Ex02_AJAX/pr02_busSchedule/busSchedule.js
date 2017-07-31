function solve() {
    const baseUrl = 'https://judgetests.firebaseio.com/schedule/';
    const infoBox = $('#info .info');
    const btnDepart = $('#depart');
    const btnArrive = $('#arrive');

    let currentStopId = 'depot';
    let currStopName = '';

    function depart() {
        let req = {
            url: baseUrl + `${currentStopId}.json`,
            method: 'GET',
            success: showDepartingInfo,
            error: showError
        };

        $.ajax(req);
    }

    function arrive() {
        infoBox.text(`Arriving at ${currStopName}`);
        btnDepart.prop('disabled', false);
        btnArrive.prop('disabled', true);
    }

    function showDepartingInfo(stop) {
        currentStopId = stop.next;
        currStopName = stop.name;
        infoBox.text(`Next stop ${currStopName}`);
        btnDepart.prop('disabled', true);
        btnArrive.prop('disabled', false);

    }

    function showError(err) {
        infoBox.text('Error');
        btnDepart.prop('disabled', true);
        btnArrive.prop('disabled', true);

    }
    return {
        depart,
        arrive
    };
}