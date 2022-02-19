function add_table_row(doc) {
    let table = document.getElementById("hits_table")
    let body = table.getElementsByTagName("tbody")[0]
    let elem = new DOMParser().parseFromString(doc, "text/html")
    let new_row = elem.getElementById("hits_table").getElementsByTagName("tbody")[0]
    show_last_hit_results(new_row.rows[0].cells[3])
    console.log(new_row)
    body.innerHTML = new_row.innerHTML + body.innerHTML
}

function show_last_hit_results(cell){
    let last_hit_result = document.getElementById("last_hit_result")
    let isHit = cell.getAttribute("class") === "hit"
    if(isHit) {last_hit_result.setAttribute("class", "hit"); last_hit_result.textContent = "hit"}
    else {last_hit_result.setAttribute("class", "miss"); last_hit_result.textContent = "miss"}
}