function loadRepos() {
    $('#res').text('Loading...');
    $('#btnLoad').prop('disabled', true);
    let username = $('#username').val();
    let repositories = $('#repos');

    let request = {
        url: `https://api.github.com/users/${username}/repos`,
        method: 'GET',
        success: showRepos,
        error: showError,
        complete: () => {
            $('#res').text('');
            $('#btnLoad').prop('disabled', false)
        }
    };

    $.ajax(request);

    function showRepos(repos) {
        repositories.empty();

        for (let repo of repos) {
            repositories.append($(`<li><a href="${repo.html_url}" target="_blank">${repo.full_name}</a></li>`))
        }
    }

    function showError(error) {
        repositories.empty();
        repositories.append($(`<li>Error: ${error.statusText}</li>`));
    }
}