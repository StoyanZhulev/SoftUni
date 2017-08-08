function startApp() {
    const baseUrl = 'https://baas.kinvey.com/';
    const appKey = 'kid_SkpEnoWvW';
    const appSecret = '1c58ce2bb9c44ce4b8fa89b89358f86e';

    const addsDiv = $('#ads');
    const detailAdDiv = $('#detailAd');
    const userAds = $('#userAdverts');
    const viewUserAdsDiv = $('#viewUserAds');

    let adBeingViewed;

    $('#linkHome').click(() => showView('viewHome'));
    $('#linkLogin').click(() => showView('viewLogin'));
    $('#linkRegister').click(() => showView('viewRegister'));
    $('#linkListAds').click(() => {
        listAds();
        showView('viewAds');
    });
    $('#linkCreateAd').click(() => showView('viewCreateAd'));
    $('#loggedInUser').click(() => {
        showProfile();
        showView('viewProfile');
    });
    $('#linkLogout').click(logout);

    showHideMenuLinks();
    showView('viewHome');

    $('#buttonRegisterUser').click(register);
    $('#buttonLoginUser').click(login);
    $('#buttonCreateAd').click(createAd);

    $(document).on({
        ajaxStart: () => $('#loadingBox').show(),
        ajaxStop: () => $('#loadingBox').hide()
    });


    $('.notification').click((e) => {
        $(e.target).hide();
    });

    $("form").submit(function (event) {
        event.preventDefault()
    });

    function showInfo(message) {
        $('#infoBox').text(message);
        $('#infoBox').show();
        setTimeout(() => $('#infoBox').fadeOut(), 3000);
    }

    function showError(message) {
        $('#errorBox').text(message);
        $('#errorBox').show();
    }

    function handleError(reason) {
        showError(reason.responseJSON.description);
    }

    function showHideMenuLinks() {
        $('#linkHome').show();
        if (sessionStorage.getItem('username') === null) {
            $('#linkLogin').show();
            $('#linkRegister').show();
            $("#linkListAds").hide();
            $("#linkCreateAd").hide();
            $("#linkLogout").hide();
            $("#loggedInUser").hide();
        } else {
            $('#linkLogin').hide();
            $('#linkRegister').hide();
            $("#linkListAds").show();
            $("#linkCreateAd").show();
            $("#linkLogout").show();
            $("#loggedInUser").text('Welcome, ' + sessionStorage.getItem('username'));
            $("#loggedInUser").show();
        }
    }

    function showView(viewName) {
        $('section').hide();
        switch (viewName) {
            case 'viewHome':
                $('#viewHome').show();
                break;
            case 'viewLogin':
                $('#viewLogin').show();
                break;
            case 'viewRegister':
                $('#viewRegister').show();
                break;
            case 'viewAds':
                listAds();
                $('#viewAds').show();
                break;
            case 'viewCreateAd':
                $('#viewCreateAd').show();
                break;
            case 'viewEditAd':
                $('#viewEditAd').show();
                break;
            case 'viewProfile':
                showProfile();
                $('#viewProfile').show();
                break;
            case 'viewAdDetail':
                $('#viewAdDetail').show();
                break;
        }
    }

    let requester = (() => {
        function makeHeader(type) {
            if (type === 'basic') {
                return {
                    'Authorization': 'Basic ' + btoa(appKey + ':' + appSecret),
                    'Content-Type': 'application/json'
                }
            } else {
                return {
                    'Authorization': 'Kinvey ' + sessionStorage.getItem('authtoken'),
                    'Content-Type': 'application/json'
                }
            }
        }

        function makeRequest(method, module, url, auth) {
            return {
                url: baseUrl + module + '/' + appKey + '/' + url,
                method,
                headers: makeHeader(auth)
            }
        }

        function get(module, url, auth) {
            return $.ajax(makeRequest('GET', module, url, auth))
        }

        function post(module, url, data, auth) {
            let req = makeRequest('POST', module, url, auth);
            req.data = JSON.stringify(data);
            return $.ajax(req);
        }

        function update(module, url, data, auth) {
            let req = makeRequest('PUT', module, url, auth);
            req.data = JSON.stringify(data);
            return $.ajax(req);
        }

        function remove(module, url, auth) {
            return $.ajax(makeRequest('DELETE', module, url, auth));
        }

        return {
            get: get,
            post: post,
            update: update,
            remove: remove
        }
    })();

    function setStorrage(data) {
        sessionStorage.setItem('authtoken', data._kmd.authtoken);
        sessionStorage.setItem('username', data.username);
        sessionStorage.setItem('userId', data._id);
        showHideMenuLinks();
    }

    async function register() {
        let username = $('#formRegister').find('input[name="username"]').val();
        let password = $('#formRegister').find('input[name="passwd"]').val();
        let confirmPassword = $('#formRegister').find('input[name="confirmPasswd"]').val();
        let ads = new Map();

        if (username.length === 0) {
            showError('Username cannot be empty!');
            return;
        }

        if (password.length === 0) {
            showError('Password cannot be empty!');
            return;
        }

        if (password !== confirmPassword) {
            showError("Passwords don't match!");
            return;
        }

        try {
            let data = await requester.post('user', '', {username, password, ads}, 'basic');
            setStorrage(data);
            showView('viewHome');
            showInfo('Successful register!');
            $('#viewRegister').find('form').trigger('reset');
        } catch (err) {
            handleError(err);
        }
    }

    async function login() {
        let username = $('#formLogin').find('input[name="username"]').val();
        let password = $('#formLogin').find('input[name="passwd"]').val();

        if (username.length === 0) {
            showError('Username cannot be empty!');
            return;
        }

        if (password.length === 0) {
            showError('Password cannot be empty!');
            return;
        }

        try {
            let data = await requester.post('user', 'login', {username, password}, 'basic');
            setStorrage(data);
            showView('viewHome');
            showInfo('Successful login!');
            $('#viewLogin').find('form').trigger('reset');
        } catch (err) {
            handleError(err);
        }
    }

    async function logout() {
        try {
            let data = await requester.post('user', '_logout', {authtoken: sessionStorage.getItem('authtoken')});
            sessionStorage.clear();
            showHideMenuLinks();
            showView('viewHome');
            showInfo('Successful logout!');
        } catch (err) {
            handleError(err);
        }
    }

    async function createAd() {
        let form = $('#formCreateAd');
        let title = form.find('input[name="title"]').val();
        let description = form.find('textarea[name="description"]').val();
        let dateOfPublishing = new Date();
        let price = form.find('input[name="price"]').val();
        let imageUrl = form.find('input[name="image"]').val();
        let publisher = sessionStorage.getItem('username');


        if (title.length === 0) {
            showError()
        }

        let ad = {
            title,
            description,
            dateOfPublishing,
            price,
            imageUrl,
            publisher
        };

        try {

            let data = await requester.post('appdata', 'adverts', ad);


            $('#viewCreateAd').find('form').trigger('reset');
            showView('viewAds');
            let user = await requester.get('user', sessionStorage.getItem('userId'));
            let ads = user.ads;
            let id = data._id;
            ads[id] = data;

            let newUser = {
                username: user.username,
                ads: ads
            };
            let userData = requester.update('user', user._id, newUser);
            showInfo('New Ad created!');
        } catch (err) {
            handleError(err);
        }
    }

    async function listAds() {
        addsDiv.empty();
        let data = await requester.get('appdata', 'adverts');
        addsDiv.empty();

        if (data.length === 0) {
            addsDiv.append('<p>No ads in database!</p>');
            return;
        }

        for (let ad of data) {
            let html = makeAdHtml(ad);
            addsDiv.append(html);
        }
    }

    function makeAdHtml(ad) {
        let adCreator = ad._acl.creator;
        let userId = sessionStorage.getItem('userId');

        let html = $('<div>');
        html.addClass('ad-box');
        let title = $(`<div class="ad-title">${ad.title}</div>`);

        if (adCreator === userId) {
            let deleteBtn = $(`<button>&#10008;</button>`).click((ev) => {
                deleteAd(ad);
                let par = $(ev.target).parent().parent();
                par.remove();
            });
            deleteBtn.addClass('ad-control');
            let editBtn = $('<button>&#9998;</button>').click(() => editAd(ad));
            editBtn.addClass('ad-control');
            title.append(deleteBtn);
            title.append(editBtn);
        }
        let viewBtn = $('<button>&#9776;</button>').click(() => viewAd(ad));
        viewBtn.addClass('ad-control');
        title.append(viewBtn);
        html.append(title);
        if (ad.imageUrl !== '') {
            html.append(`<div><img src="${ad.imageUrl}"></div>`);
        } else {
            html.append(`<div><img src="styles/static/no-image.jpg"></div>`);
        }
        html.append(`<div class="ad-title">Price: ${Number(ad.price).toFixed(2)}</div>`);
        html.append(`<div class="ad-title">Publisher: ${ad.publisher}</div>`);

        return html;
    }

    async function viewAd(ad) {
        detailAdDiv.empty();
        userAds.empty();
        viewUserAdsDiv.empty();
        let date = ad.dateOfPublishing.split('-');
        let year = date[0];
        let month = date[1];
        let day = date[2].substr(0, 2);
        let html = $('<div class="htm" style="border: 1px solid black" ></div>')
            .append($(`<h1 class="titleForm">${ad.title}</h1>`));

        if (ad.imageUrl !== '') {
            html.append($(`<div class="htm"><img src="${ad.imageUrl}" style="float: left"></div>`));

        } else {
            html.append(`<div class="htm"><img src="styles/static/no-image.jpg"></div>`);
        }

        html.append($(`<div class="htm"><p class="text">Description: </p></div>`)
            .append($(`<textarea class="textarea" disabled></textarea>`).val(ad.description))
        ).append($(`<div class="htm"><p class="text">Ad Info: </p><br></div>`)
            .append($(`<p class="infoText">Publisher: <i><strong>${ad.publisher}</strong></i></p>`))
            .append($(`<p class="infoText">Date published: ${day}/${month}/${year}</p>`))
        );

        let buttons = makeShowAndHideButtons(userAds, ad._acl.creator);
        viewUserAdsDiv.append($('<p class="text">View all ads from this user:</p>'));
        viewUserAdsDiv.append(buttons.showBtn);
        viewUserAdsDiv.append(buttons.hideBtn);
        detailAdDiv.append(html);

        showView('viewAdDetail');
    }

    async function editAd(ad) {
        showView('viewEditAd');
        let form = $('#formEditAd');
        form.find('input[name="title"]').val(ad.title);
        form.find('textarea[name="description"]').val(ad.description);
        form.find('input[name="price"]').val(Number(ad.price));
        form.find('input[name="image"]').val(ad.imageUrl);

        $('#buttonEditAd').click(edit);

        async function edit() {
            let title = form.find('input[name="title"]').val();
            let description = form.find('textarea[name="description"]').val();
            let dateOfPublishing = (new Date()).toString('dd-MM-yyyy');
            let price = form.find('input[name="price"]').val();
            let imageUrl = form.find('input[name="image"]').val();
            let publisher = sessionStorage.getItem('username');

            let newAd = {
                title,
                description,
                dateOfPublishing,
                price,
                imageUrl,
                publisher
            };

            try {
                let data = await requester.update('appdata', `adverts/${ad._id}`, newAd);
                $('#viewEditAd').find('form').trigger('reset');
                showView('viewAds');
                showInfo(`Ad "${data.title}" updated`);
                let user = await requester.get('user', sessionStorage.getItem('userId'));
                let ads = user.ads;
                let id = ad._id;

                ads[id] = data;
                let newUser = {
                    username: user.username,
                    ads: ads
                };

                let userData = requester.update('user', user._id, newUser);
            } catch (err) {
                handleError(err);
            }
        }
    }

    async function deleteAd(ad) {
        try {
            let data = await requester.remove('appdata', `adverts/${ad._id}`);

            showInfo(`${ad.title} deleted!`);
            let user = await requester.get('user', sessionStorage.getItem('userId'));
            let ads = user.ads;
            delete ads[ad._id];

            let newUser = {
                username: user.username,
                ads: ads
            };

            let userData = requester.update('user', user._id, newUser);
        } catch (err) {
            handleError(err);
        }

    }

    function makeShowAndHideButtons(adsDiv, userId) {
        let showBtn = $('<input type="prButton" value="Show ads &#11022;"/>').click(showAds);

        let hideBtn = $('<input type="prButton" value="Hide ads &#11023;"/>').click(hideAds);
        hideBtn.hide();

        async function showAds() {
            showBtn.hide();
            hideBtn.show();
            let user = await requester.get('user', userId);

            let ads = user.ads;
            if (Object.getOwnPropertyNames(ads).length === 0) {
                adsDiv.append('<p>No ads in database!</p>');
                return;
            }
            for (let adKey in ads) {
                let ad = ads[adKey];
                let html = makeAdHtml(ad);
                adsDiv.append(html);
            }
        }

        function hideAds() {
            showBtn.show();
            hideBtn.hide();
            adsDiv.empty();
        }

        return{
            showBtn,
            hideBtn
        }
    }

    function showProfile() {
        let div = $('#profile');
        let adsDiv = $('#adverts');
        div.empty();
        adsDiv.empty();
        let userDiv = $(`<div class="htm" ><p class="text">User Info: </p><br></div>`)
            .append($(`<p class="infoText">Username: <i><strong>${sessionStorage.getItem('username')}</strong></i></p>`));
        let buttons = makeShowAndHideButtons(adsDiv, sessionStorage.getItem('userId'));
        userDiv.append(buttons.showBtn);
        userDiv.append(buttons.hideBtn);
        div.append(userDiv);
    }
}