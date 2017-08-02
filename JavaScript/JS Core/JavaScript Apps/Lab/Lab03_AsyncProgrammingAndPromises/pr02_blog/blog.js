function attachEvents() {
    const baseUrl = 'https://baas.kinvey.com/appdata/kid_BySomIJP-/';
    const username = 'zhulev';
    const password = 'z';

    const select = $('#posts');
    const postTitle = $('#post-title');
    const postBody = $('#post-body');
    const comments = $('#post-comments');

    $('#btnLoadPosts').click(loadPosts);
    $('#btnViewPost').click(viewPost);

    function loadPosts() {
        let req = {
            url: baseUrl + 'posts',
            method: 'GET',
            headers: {
                'Authorization': "Basic " + btoa(username + ":" + password)
            },
            success: attachPostOptions,
            error: handleError
        };

        $.ajax(req);
    }

    function attachPostOptions(data) {
        select.empty();
        for (let obj of data) {
            let opt = $(`<option>${obj.title}</option>`);
            opt.val(obj._id);
            select.append(opt);
        }
    }

    function handleError(err) {
        let errorDiv = $("<div>").text("Error: " + err.status + ' (' + err.statusText + ')');
        $(document.body).prepend(errorDiv);
    }

    function viewPost() {
        let selectedId = select.find('option:selected').val();

        let req = {
            url: baseUrl + `posts/${selectedId}`,
            method: 'GET',
            headers: {
                'Authorization': "Basic " + btoa(username + ":" + password)
            },
            success: displayPost,
            error: handleError
        };

        $.ajax(req);
    }

    function displayPost(post) {
        postTitle.empty();
        postBody.empty();
        postTitle.text(post.title);
        postBody.text(post.body);

        let req = {
            url: baseUrl + `comments/?query={"post_id":"${post._id}"}`,
            method: 'GET',
            headers: {
                'Authorization': "Basic " + btoa(username + ":" + password)
            },
            success: displayComments,
            error: handleError
        };

        $.ajax(req);
    }

    function displayComments(data) {
        comments.empty();
        for (let comment of data) {
            comments.append($(`<li>${comment.text}</li>`))
        }
    }
}