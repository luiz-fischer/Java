var prevScrollpos = window.pageYOffset;

window.onscroll = function () {
    var currentScrollPos = window.pageYOffset;

    if (prevScrollpos > currentScrollPos) {
        document.getElementById("navbar").style.setProperty("background-color", "transparent", "important");
    }
    else {
        document.getElementById("navbar").style.backgroundColor = "";
    }
    prevScrollpos = currentScrollPos;
}