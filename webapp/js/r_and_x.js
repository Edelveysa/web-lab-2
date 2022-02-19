function get_r(){
    let r = document.querySelector('input[name="r_input"]:checked');
    if(r != null ){return r.value;}
    return 0;
}

function get_x(){
    let x = document.querySelector('input[name="x_input"]:checked');
    return x.value;
}