function attachEvents() {
    const baseUrl = 'https://baas.kinvey.com/appdata/kid_BympCLgD-/biggestCatches';
    const username = 'zhulev';
    const password = 'z';
    const catches = $('#catches');


    $('.add').click(addCatch);
    $('.load').click(loadCatches);


    function addCatch() {

        let angler = $('#addForm .angler');
        let weight = $('#addForm .weight');
        let species = $('#addForm .species');
        let location = $('#addForm .location');
        let bait = $('#addForm .bait');
        let captureTime = $('#addForm .captureTime');
        let req = {
            url: baseUrl,
            method: 'POST',
            contentType: 'application/json',
            headers: {
                'Authorization': "Basic " + btoa(username + ":" + password)
            },
            data: JSON.stringify({
                angler: angler.val(),
                weight: Number(weight.val()),
                species: species.val(),
                location: location.val(),
                bait: bait.val(),
                captureTime: Number(captureTime.val())
            }),
            success: addToHtml,
            error: handleError
        };

        $.ajax(req);

        angler.val('');
        weight.val('');
        species.val('');
        location.val('');
        bait.val('');
        captureTime.val('');
    }

    function addToHtml(data) {
        catches.find('i').remove();
        let currCatch = $(`<div class="catch" data-id="${data._id}"></div>`);
        currCatch.append($('<label>Angler</label>'))
            .append($(`<input type="text" class="angler" value="${data.angler}"/>`))
            .append($('<label>Weight</label>'))
            .append($(`<input type="number" class="weight" value="${data.weight}"/>`))
            .append($('<label>Species</label>'))
            .append($(`<input type="text" class="species" value="${data.species}"/>`))
            .append($('<label>Location</label>'))
            .append($(`<input type="text" class="location" value="${data.location}"/>`))
            .append($('<label>Bait</label>'))
            .append($(`<input type="text" class="bait" value="${data.bait}"/>`))
            .append($('<label>Capture Time</label>'))
            .append($(`<input type="number" class="captureTime" value="${data.captureTime}"/>`));
        let updateBtn = $('<button>Update</button>').addClass('update').click(updateCatch);
        let deleteBtn = $('<button>Delete</button>').addClass('delete').click(deleteCatch);
        currCatch.append(updateBtn);
        currCatch.append(deleteBtn);
        catches.append(currCatch);

    }


    function handleError(err) {
       alert(err.statusText);
    }

    function loadCatches() {
        let req = {
            url: baseUrl,
            method: 'GET',
            headers: {
                'Authorization': "Basic " + btoa(username + ":" + password)
            },
            success: showCatches,
            error: handleError
        };

        $.ajax(req);

        function showCatches(data) {
            catches.empty();
            if(data.length === 0){
               catches.append($('<i>No catches to show..</i>'))
            }else{
                for (let c of data) {
                    addToHtml(c)
                }
            }
        }
    }

    function updateCatch() {
        let catchDiv = $(this).parent();
        let inputs = catchDiv.find('input');

        // let angler = catchDiv.find('.angler');
        // let weight = catchDiv.find('.weight');
        // let species = catchDiv.find('.species');
        // let location = catchDiv.find('.location');
        // let bait = catchDiv.find('.bait');
        // let captureTime = catchDiv.find('.captureTime');

        let req = {
            url: baseUrl + `/${catchDiv.attr("data-id")}`,
            method: 'PUT',
            contentType: 'application/json',
            headers: {
                'Authorization': "Basic " + btoa(username + ":" + password)
            },
            data: JSON.stringify({
                angler: $(inputs[0]).val(),
                weight: $(inputs[1]).val(),
                species: $(inputs[2]).val(),
                location: $(inputs[3]).val(),
                bait: $(inputs[4]).val(),
                captureTime: $(inputs[5]).val()
            }),
            error: handleError
        };

        $.ajax(req);
    }

    function deleteCatch() {
        let catchDiv = $(this).parent();
        let req = {
            url: baseUrl + `/${catchDiv.attr("data-id")}`,
            method: 'DELETE',
            contentType: 'application/json',
            headers: {
                'Authorization': "Basic " + btoa(username + ":" + password)
            },
            error: handleError
        };
        catchDiv.remove();

        $.ajax(req);


    }
}