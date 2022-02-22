function isNumeric(y) {
    if (y.length > 5) return false
    return !isNaN(parseFloat(y));
}

function check_y() {
    let y = document.querySelector("input[id=y_input]").value.replace(",", ".");
    if (y === undefined) {
        alert("Введите Y");
        return null;
    }
    if (!isNumeric(y)) {
        alert("Y не является числом");
        return null;
    }
    if (!((y >= -5) && (y <= 5))) {
        alert("Y не входит в область допустимых значений");
        return null;
    }
    return y;
}

function check_r() {
    let rRadio = document.querySelector('input[name="r_input"]:checked');
    if (rRadio === null || rRadio === undefined) {
        alert("Выберите Y");
        return null;
    }
    return rRadio.value;
}

function check_x() {
    let xRadio = document.querySelector('input[name="x_input"]:checked');
    if (xRadio === null || xRadio === undefined) {
        alert("Выберите X");
        return null;
    }
    return xRadio.value;
}

function shoot_request(x, y, r){
    let request = new XMLHttpRequest();
    request.open('get', "./controller?x="+x+"&y="+y+"&r="+r, true)
    request.overrideMimeType("text/html");
    request.onload = function () {
        let text = request.responseText
        add_table_row(text)
        render_canvas(r)
    }
    request.send()
}

function shoot() {
    let x = check_x(), y = check_y(), r = check_r();
    if (x != null && y != null && r != null)
        shoot_request(x, y, r);
    else alert("Недопустимые данные формы");

}