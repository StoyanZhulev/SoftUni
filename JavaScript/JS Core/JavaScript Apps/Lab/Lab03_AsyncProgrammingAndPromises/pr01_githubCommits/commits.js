function loadCommits() {
    const baseUrl = 'https://api.github.com/repos/';
    const list = $('#commits');

    let username = $('#username').val();
    let repo = $('#repo').val();

    let req = {
        url: baseUrl + `${username}/${repo}/commits`,
        method: 'GET'
    };

    $.ajax(req)
        .then(showCommits)
        .catch(handleError);

    function showCommits(data) {
        list.empty();
        for (let el of data) {
            list.append($(`<li>${el.commit.author.name}: ${el.commit.message}</li>`));
        }
    }

    function handleError(err) {
        list.empty();
        list.append($(`<li>Error: ${err.status} (${err.statusText})</li>`))
    }
}