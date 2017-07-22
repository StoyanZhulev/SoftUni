function attachEventsListeners() {
    let daysB = document.getElementById('daysBtn');
    let hoursB = document.getElementById('hoursBtn');
    let minutesB = document.getElementById('minutesBtn');
    let secondsB = document.getElementById('secondsBtn');

    function convertDays() {
        let currentDays = Number(document.getElementById('days').value);
        document.getElementById('hours').value = currentDays * 24;
        document.getElementById('minutes').value = currentDays * 24 * 60;
        document.getElementById('seconds').value = currentDays * 24 * 60 * 60;
    }

    function convertHours() {
        let currentHours = Number(document.getElementById('hours').value);
        document.getElementById('days').value = currentHours / 24;
        document.getElementById('minutes').value = currentHours * 60;
        document.getElementById('seconds').value = currentHours * 60 * 60;
    }

    function convertMinutes() {
        let currentMinutes = Number(document.getElementById('minutes').value);
        document.getElementById('days').value = currentMinutes / (24* 60);
        document.getElementById('hours').value = currentMinutes / (60);
        document.getElementById('seconds').value = currentMinutes * 60;
    }

    function convertSeconds() {
            let currentSeconds = Number(document.getElementById('seconds').value);
            document.getElementById('days').value = currentSeconds / (24 * 60 * 60);
            document.getElementById('hours').value = currentSeconds / (60 * 60);
            document.getElementById('minutes').value = currentSeconds / 60;
    }

    daysB.addEventListener('click', convertDays);
    hoursB.addEventListener('click', convertHours);
    minutesB.addEventListener('click', convertMinutes);
    secondsB.addEventListener('click', convertSeconds);
}