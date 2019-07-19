function getDrinks() {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "/getdrinks", false);
    xhr.send();
    return JSON.parse(xhr.responseText)
}

function createDrink(drink) {
    return (<article className="product col m-3" id="${drink.id}">
        <a href="" className="product-name"><h3>${drink.name}</h3></a>
        <a href=""><img className="product-img" src="../img/alco/beer.png" alt="alco-img" /></a>
        <h4>&#9733; &#9733; &#9733; &#9733; &#9734;</h4>
        <p className="description">${drink.description}</p>
        <p>Крепость: 4.7%</p>
    </article>)
}

let drinks = getDrinks();
let htmlDrinks;

drinks.array.forEach(element => {
    htmlDrinks += createDrink(element) + " ";
});

ReactDOM.render(htmlDrinks, document.getElementById("root-main"));