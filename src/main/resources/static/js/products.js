getJson();

function getJson() {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "/getdrinks", false);
    // xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
    console.log("Test 4");
    let drinks = JSON.parse(xhr.responseText)
    console.log(drinks[0]);
}