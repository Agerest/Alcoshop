getJson();

function getJson() {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/getdrinks", true);
    xhr.send();
    if (xhr.status == 200) {
        console.log("JSON" + xhr.responseText);
    } else {
        console.log("ERROR" + xhr.status + " " + xhr.statusText);
    }
}