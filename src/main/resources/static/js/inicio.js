$("document").ready(function($){
    var nav = $('#header');

    $(window).scroll(function () {
        if ($(this).scrollTop() > 120) {
            nav.addClass("navbar-home");
        } else {
            nav.removeClass("navbar-home");
        }
    });
});