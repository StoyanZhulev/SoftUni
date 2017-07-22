function getArticleGenerator(articles) {
    let container = $('#content');
    return function showNext() {
        if(articles.length > 0){
            $(container).append(`<article>${articles.shift()}</article>`);
        }
    }
}
