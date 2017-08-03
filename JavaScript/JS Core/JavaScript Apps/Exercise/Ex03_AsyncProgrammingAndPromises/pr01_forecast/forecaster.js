function attachEvents() {
    const baseUrl = 'https://judgetests.firebaseio.com/';
    const icons = [];
    icons['Sunny'] = '&#x2600;';
    icons['Partly sunny'] = '&#x26C5;';
    icons['Overcast'] = '&#x2601;';
    icons['Rain'] = '&#x2614;';
    icons['Degrees'] = '&#176;';
    $('#submit').click(getLocations);

    function request(endpoint) {
        return $.ajax({
            url: baseUrl + endpoint,
            method: 'GET'
        });

    }

    function getLocations() {
        let locationPromise = request('locations.json');
        locationPromise.then(findLocation)
            .catch(handleError);

    }

    function findLocation(data) {
        let desiredLocation = $('#location').val();
        let location;
        let isFound = false;
        for (let loc of data) {
            if (loc.name === desiredLocation) {
                location = loc;
                getForecast(location);
                isFound = true;
                break;
            }
        }

        if(!isFound){
            handleError();
        }
    }

    function getForecast(location) {
        let currentP = request(`forecast/today/${location.code}.json`);
        let nextDaysP = request(`forecast/upcoming/${location.code}.json`);
        Promise.all([currentP, nextDaysP])
            .then(displayInfo)
            .catch(handleError);

        function displayInfo([currentDay, nextDays]) {
            let forecast = $('#forecast');
            let [day1, day2, day3] = nextDays.forecast;
            forecast.css('display', 'block');
            $('#current').empty();
            $('#current').append($('<div class="label">Current conditions</div>'))
                .append($(`<span class="condition symbol">${icons[currentDay.forecast.condition]}</span>`))
                .append($(`<span class="condition"></span>`)
                    .append($(`<span class="forecast-data">${currentDay.name}</span>`))
                    .append($(`<span class="forecast-data">${currentDay.forecast.low}${icons['Degrees']}/${currentDay.forecast.high}${icons['Degrees']}</span>`))
                    .append($(`<span class="forecast-data">${currentDay.forecast.condition}</span>`))
                );

            $('#upcoming').empty();
            $('#upcoming').append($('<div class="label">Three-day forecast</div>'))
                .append($('<span class="upcoming"></span>')
                    .append($(`<span class="symbol">${icons[day1.condition]}</span>`))
                    .append($(`<span class="forecast-data">${day1.low}${icons['Degrees']}/${day1.high}${icons['Degrees']}</span>`))
                    .append($(`<span class="forecast-data">${day1.condition}</span>`))
                ).append($('<span class="upcoming"></span>')
                .append($(`<span class="symbol">${icons[day2.condition]}</span>`))
                .append($(`<span class="forecast-data">${day2.low}${icons['Degrees']}/${day2.high}${icons['Degrees']}</span>`))
                .append($(`<span class="forecast-data">${day2.condition}</span>`))
            ).append(
                $('<span class="upcoming"></span>')
                    .append($(`<span class="symbol">${icons[day3.condition]}</span>`))
                    .append($(`<span class="forecast-data">${day3.low}${icons['Degrees']}/${day3.high}${icons['Degrees']}</span>`))
                    .append($(`<span class="forecast-data">${day3.condition}</span>`))
            )
        }
    }

    function handleError(reason) {
        let forecast = $('#forecast');
        forecast.empty();
        forecast.css('display', 'block');
        forecast.append($('<p>Error</p>'));
    }
}