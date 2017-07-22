function timer() {
    let hours = $('#hours');
    let minutes = $('#minutes');
    let seconds = $('#seconds');

    let timer;
    let started = false;

    let time = 0;

    $('#start-timer').on('click', function () {
        if(!started){
            started = true;
            timer = setInterval(step, 1000);
        }
    });

    $('#stop-timer').click(function () {
        if(started){
            started = false;
            clearInterval(timer);
        }
    });

    function step() {
        time++;

        let h =  ((Math.floor(time / 3600)));
        h = ('0' + h).slice(-2);

        let m = ('0' + (Math.floor(time / 60) % 60)).slice(-2);
        let s = ('0' + (time % 60)).slice(-2);

        $(hours).text(h);
        $(minutes).text(m);
        $(seconds).text(s);
    }
}