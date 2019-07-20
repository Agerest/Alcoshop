let drinks = getDrinks();
let htmlDrinks = drinks.map((drink) => createDrink(drink));

ReactDOM.render(htmlDrinks, document.getElementById("root-main"));

function getDrinks() {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "/getdrinks", false);
    xhr.send();
    return JSON.parse(xhr.responseText)
}

function createDrink(drink) {
    return (<article class="product col-4">
        <a href="" class="product-name">
            <h3>{drink.name}</h3>
        </a>
        <a href=""><img class="product-img" src="/img/alco/beer.png" alt="alco-img" /></a>
        <h4>&#9733; &#9733; &#9733; &#9733; &#9734;</h4>
        <p>{drink.description}</p>
        <p>Крепость: 4.7%</p>
    </article>)
}

function showNavDropdown(id) {
    let element = document.getElementById("dropdown-" + id);
    if (element.style.display === "flex") {
        element.style.display = "none";
    } else {
        element.style.display = "flex";
    }
}

