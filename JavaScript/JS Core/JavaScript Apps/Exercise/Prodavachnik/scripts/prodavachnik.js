function startApp() {
    const app = Sammy('#main', function () {
        let advertisementId = '';
        $('.notification').click((e) => {
            $(e.target).hide();
        });
        this.use('Handlebars', 'hbs');

        //HOME
        this.get('index.html', displayHome);
        this.get('#/home', displayHome);

        function displayHome(ctx) {
            ctx.loggedIn = userManager.isLoggedIn();
            ctx.username = userManager.getUsername();
            ctx.id = sessionStorage.getItem('userId');
            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs'
            }).then(function () {
                this.partial('./templates/home/home.hbs');
            })
        }

        //REGISTER
        this.get('#/register', function (ctx) {
            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
                registerForm: './templates/register/registerForm.hbs'
            }).then(function () {
                this.partial('./templates/register/registerPage.hbs')
            });
        });

        this.post('#/register', function (ctx) {
            let username = ctx.params.username;
            let pass = ctx.params.password;
            let confirmPass = ctx.params.confirmPassword;

            userManager.register(username, pass, confirmPass)
                .then(function (userInfo) {
                    userManager.saveSession(userInfo);
                    displayHome(ctx);
                    messageBox.showInfo('Successful register!');
                }).catch(messageBox.handleError);
        });

        //LOGIN
        this.get('#/login', function (ctx) {
            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
                loginForm: './templates/login/loginForm.hbs'
            }).then(function () {
                this.partial('./templates/login/loginPage.hbs');
            });
        });

        this.post('#/login', function (ctx) {
            let username = ctx.params.username;
            let password = ctx.params.password;

            userManager.login(username, password)
                .then(function (userInfo) {
                    userManager.saveSession(userInfo);
                    displayHome(ctx);
                    messageBox.showInfo('Successful login!');
                }).catch(messageBox.handleError);
        });

        //LOGOUT
        this.get('#/logout', function (ctx) {
            userManager.logout()
                .then(function () {
                    sessionStorage.clear();
                    displayHome(ctx);
                    messageBox.showInfo('Successful logout!');
                }).catch(messageBox.handleError)
        });

        //CATALOG
        function displayAds(ctx) {
            adsManager.getAds()
                .then(function (ads) {
                    ctx.loggedIn = userManager.isLoggedIn();
                    ads.map(a => a.isCreator = sessionStorage.getItem('userId') === adsManager.getAdCreator(a));
                    ctx.username = userManager.getUsername();
                    ctx.id = sessionStorage.getItem('userId');
                    ctx.ads = ads;
                    ctx.loadPartials({
                        header: './templates/common/header.hbs',
                        footer: './templates/common/footer.hbs',
                        adBox: './templates/catalog/adBox.hbs'
                    }).then(function () {
                        this.partial('./templates/catalog/adsPage.hbs')
                    })
                }).catch(messageBox.handleError);


        }

        this.get('#/ads', displayAds);

        //CREATE AD
        this.get('#/createAd', function (ctx) {
            ctx.loggedIn = userManager.isLoggedIn();
            ctx.username = userManager.getUsername();
            ctx.id = sessionStorage.getItem('userId');

            ctx.loadPartials({
                header: './templates/common/header.hbs',
                footer: './templates/common/footer.hbs',
                createAdForm: './templates/ad/create/createAdForm.hbs'
            }).then(function () {
                this.partial('./templates/ad/create/createAdPage.hbs')
            })
        });

        this.post('#/createAd', function (ctx) {
            let title = ctx.params.title;
            let description = ctx.params.description;
            let dateOfPublishing = new Date();
            let price = ctx.params.price;
            let imageUrl = ctx.params.image;
            let publisher = userManager.getUsername();

            let ad = {
                title,
                description,
                dateOfPublishing,
                price,
                imageUrl,
                publisher
            };

            adsManager.createAd(ad)
                .then(function (adInfo) {

                    displayAds(ctx);
                    messageBox.showInfo(`Ad "${ad.title}" created!`);
                    userManager.getUser(sessionStorage.getItem('userId'))
                        .then(function (user) {
                            let ads = user.ads;
                            let adId = adInfo._id;

                            ads[adId] = adInfo;


                            let newUser = {
                                username: user.username,
                                ads: ads
                            };

                            userManager.updateUser(newUser, user._id);
                        }).catch(messageBox.handleError)
                }).catch(messageBox.handleError)
        });

        //EDIT AD
        this.get('#/ads/edit/:id', function (ctx) {
            let adId = ctx.params.id.substring(1);
            advertisementId = adId;
            adsManager.getAdDetails(adId)
                .then(function (ad) {
                    ctx.id = sessionStorage.getItem('userId');
                    ctx.loggedIn = userManager.isLoggedIn();
                    ctx.username = userManager.getUsername();
                    ctx.title = ad.title;
                    ctx.imageUrl = ad.imageUrl;
                    ctx.description = ad.description;
                    ctx.publisher = ad.publisher;
                    ctx.dateOfPublishing = ad.dateOfPublishing;
                    ctx.price = ad.price;
                    ctx.loadPartials({
                        header: './templates/common/header.hbs',
                        footer: './templates/common/footer.hbs',
                        editAdForm: './templates/ad/edit/editAdForm.hbs'
                    }).then(function () {
                        this.partial('./templates/ad/edit/editAdPage.hbs');
                    })
                })
        });

        this.post('#/ads/edit/:id', function (ctx) {
            ctx.loggedIn = userManager.isLoggedIn();
            ctx.username = userManager.getUsername();
            ctx.id = sessionStorage.getItem('userId');
            let title = ctx.params.title;
            let imageUrl = ctx.params.image;
            let description = ctx.params.description;
            let publisher = userManager.getUsername();
            let price = Number(ctx.params.price);
            let dateOfPublishing = new Date();

            let ad = {
                title,
                description,
                dateOfPublishing,
                price,
                imageUrl,
                publisher
            };

            adsManager.editAd(advertisementId, ad)
                .then(function (adInfo) {
                    displayAds(ctx);
                    messageBox.showInfo(`Ad "${ad.title}" updated!`);
                    userManager.getUser(sessionStorage.getItem('userId'))
                        .then(function (user) {
                            let ads = user.ads;

                            ads[advertisementId] = adInfo;

                            let newUser = {
                                username: user.username,
                                ads: ads
                            };

                            userManager.updateUser(newUser, user._id);
                        })
                }).catch(messageBox.handleError);
        });

        //AD DETAILS
        this.get('#/ads/:id', function (ctx) {
            let adId = ctx.params.id.substring(1);
            adsManager.getAdDetails(adId)
                .then(function (ad) {
                    ctx.id = sessionStorage.getItem('userId');
                    ctx.loggedIn = userManager.isLoggedIn();
                    ctx.username = userManager.getUsername();
                    ctx.title = ad.title;
                    ctx.imageUrl = ad.imageUrl;
                    ctx.description = ad.description;
                    ctx.publisher = ad.publisher;
                    ctx.creator = adsManager.getAdCreator(ad);
                    let date = ad.dateOfPublishing.split('-');
                    let year = date[0];
                    let month = date[1];
                    let day = date[2].substr(0, 2);
                    ctx.datePublished = `${day}/${month}/${year}`;

                    userManager.getUser(adsManager.getAdCreator(ad))
                        .then(function (userData) {
                            let ads = userData.ads;
                            for (let key in ads) {
                                ads[key].isCreator = ctx.id === adsManager.getAdCreator(ads[key]);
                            }
                            ctx.ads = ads;
                            ctx.loadPartials({
                                header: './templates/common/header.hbs',
                                footer: './templates/common/footer.hbs',
                                adBox: './templates/catalog/adBox.hbs'
                            }).then(function () {
                                this.partial('./templates/ad/adDetailPage.hbs');
                            })
                        })

                }).catch(messageBox.handleError);
        });

        //DELETE AD
        this.get('#/ads/delete/:id', function (ctx) {
            advertisementId = ctx.params.id.substring(1);
            adsManager.deleteAd(advertisementId)
                .then(function () {
                    displayAds(ctx);
                }).catch(messageBox.handleError);

            messageBox.showInfo('Ad deleted!');
            userManager.getUser(sessionStorage.getItem('userId'))
                .then(function (user) {
                    let ads = user.ads;
                    delete ads[advertisementId];
                    let newUser = {
                        username: user.username,
                        ads: ads
                    };

                    userManager.updateUser(newUser, user._id)
                        .then()
                        .catch(messageBox.handleError);
                }).catch(messageBox.handleError);
        });

        //USER PROFILE
        this.get('#/profile/:id', function (ctx) {
            let profileId = ctx.params.id.substring(1);
            ctx.id = sessionStorage.getItem('userId');
            ctx.loggedIn = userManager.isLoggedIn();
            ctx.username = userManager.getUsername();

            userManager.getUser(profileId)
                .then(function (userData) {
                    let ads = userData.ads;
                    for (let key in ads) {
                        ads[key].isCreator = ctx.id === adsManager.getAdCreator(ads[key]);
                    }
                    ctx.ads = ads;
                    ctx.loadPartials({
                        header: './templates/common/header.hbs',
                        footer: './templates/common/footer.hbs',
                        adBox: './templates/catalog/adBox.hbs'
                    }).then(function () {
                        this.partial('./templates/profile/profilePage.hbs');
                    })
                })
        });
    });
    app.run();
}