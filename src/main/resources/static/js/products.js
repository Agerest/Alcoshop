getJson();

function getJson() {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/getdrinks", true);
    xhr.send();
    if (xhr.status == 200) {
        console.log(xhr.responseText);
    } else {
        console.log(xhr.status + " " + xhr.statusText);
    }
}