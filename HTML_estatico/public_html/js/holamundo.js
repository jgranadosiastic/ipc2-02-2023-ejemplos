show = true;
function myFunction() {
    document.getElementById("demo")
            .innerHTML = "Contenido cambiado";

}
function hideShow() {
    if (show) {
        document.getElementById("otro").style['display'] = 'none';
    } else {
        document.getElementById("otro").style['display'] = 'block';
    }
    show = !show;

}