ЯgetJson();

function getJson() {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/getdrinks", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
    console.log("Test 2");
    if (xhr.status == 200) {
        console.log("JSON " + xhr.responseText);
    } else {
        console.log("ERROR " + xhr.status + " " + xhr.statusText);
    }
}