let adsManager = (() => {

    function getAds() {
        return requester.get('appdata', 'adverts');
    }

    function getAdDetails(id) {
        return requester.get('appdata', `adverts/${id}`)
    }

    function editAd(id, ad) {
        return requester.update('appdata', `adverts/${id}`, ad);
    }

    function createAd(ad) {
        return requester.post('appdata', 'adverts', ad)
    }

    function deleteAd(adId) {
        return requester.remove('appdata', `adverts/${adId}`);
    }

    function getAdCreator(ad) {
        return ad._acl.creator;
    }

    return {
        getAds,
        getAdDetails,
        editAd,
        createAd,
        deleteAd,
        getAdCreator
    }

})();