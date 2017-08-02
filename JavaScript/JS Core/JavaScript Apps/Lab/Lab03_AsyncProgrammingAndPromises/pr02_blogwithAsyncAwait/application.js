$(() => {
    //Application constants
    const baseUrl = 'https://baas.kinvey.com/appdata/kid_BySomIJP-/';
    const username = 'zhulev';
    const password = 'z';

    //DOM Elements
    const select = $('#posts');
    const content = $('#content')

    //Attach event listeners
    select.on('change', viewPost);

    loadPosts();

    function request(endpoint) {
        return $.ajax({
            url: baseUrl + endpoint,
            headers: {
                'Authorization': "Basic " + btoa(username + ":" + password)
            }
        });
    }

    async function loadPosts() {
        select.empty();
        select.append($('<option>Loading...</option>'));
        select.prop('disabled', true);

        //Request all posts from database and display them
        try{
            fillSelect(await request('posts'));
        }catch (reason){
            handleError(reason);
        }finally {
            select.prop('disabled', false)
        }
        function fillSelect(data) {
            select.empty();
            for (let post of data) {
                $('<option>')
                    .text(post.title)
                    .val(post._id)
                    .appendTo(select);
            }

            if(data.length !== 0){
                viewPost();
            }
        }
    }

    async function viewPost() {
        select.prop('disabled', true);
        content.empty();
        content.append('<span><i>Loading...</i></span>');

        //Request only selected post and its comments
        let postId = select.find('option:selected').val();
        let postP = request('posts/' + postId);
        let commentsP = request(`comments/?query={"postId":"${postId}"}`);
        try{
            let [data, comments] = await Promise.all([postP, commentsP])

        }catch (reason){
            handleError(reason);
        }finally {
            select.prop('disabled', false);
        }

        //Display post and comments
        function displayPostAndComments([data, comments]) {
            content.empty();
            content.append($(`<h1>${data.title}</h1>`));
            content.append($(`<p>${data.body}</p>`));
            content.append($('<h2>Comments</h2>'));

            let list = $('<ul>');
            for (let comment of comments) {
                list.append($(`<li>${comment.text}</li>`));
            }
            content.append(list);
            select.prop('disabled', false);
        }
    }

    function handleError(reason) {
        content.html(`<p>Error: ${reason.statusText}`);
    }
});