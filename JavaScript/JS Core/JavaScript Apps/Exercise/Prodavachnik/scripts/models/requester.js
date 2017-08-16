let requester = (() => {
    const baseUrl = 'https://baas.kinvey.com/';
    const appKey = 'kid_SkpEnoWvW';
    const appSecret = '1c58ce2bb9c44ce4b8fa89b89358f86e';

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
