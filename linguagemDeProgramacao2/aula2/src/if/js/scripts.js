let selectShirt = document.querySelector("#select-tshirt");
let lblResult = document.querySelector("#lbl-result");

selectShirt.addEventListener('change', choiceShirt);

function choiceShirt(){
    console.log(selectShirt.value);

    if (selectShirt.value == "Avai" || selectShirt.value == "Figueira") {
        lblResult.innerHTML = `<b>The selected t-shirt is: ${selectShirt.value} 200R$</b>`;
    }else{
        lblResult.innerHTML = `<b>The selected t-shirt is: ${selectShirt.value} 4R$</b>`;
    }
}