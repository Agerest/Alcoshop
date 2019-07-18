let selectedProduct = -1;
let products = document.getElementsByClassName("product");

for (let i = 0; i < products.length; i++){
    products.item(i).onclick = function (event) {
        if (selectedProduct !== -1) {
            document.getElementById(selectedProduct).style.background = "inherit";
        }

        selectedProduct = this.id;
        document.getElementById(selectedProduct).style.background = "blue";
    };
}