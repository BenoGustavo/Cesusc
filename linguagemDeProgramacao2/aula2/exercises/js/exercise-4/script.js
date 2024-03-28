window.onload = function () {
    let radio_inputs = document.querySelectorAll('input[type="radio"]');
    let img = document.getElementById('food_img');
    let image_tittle = document.getElementById('image_tittle');

    for (let i = 0; i < radio_inputs.length; i++) {
        radio_inputs[i].addEventListener('change', function () {
            switch (radio_inputs[i].id) {
                case 'bbq_input':
                    if (radio_inputs[i].checked) {
                        image_tittle.innerText = "BBQ";
                        img.src = "misc/img/BBQ.jpg";
                    }
                    break;
                case 'acai_input':
                    if (radio_inputs[i].checked) {
                        image_tittle.innerText = "Açai";
                        img.src = "misc/img/acai.jpg";
                    }
                    break;
                case 'carreteiro_input':
                    if (radio_inputs[i].checked) {
                        image_tittle.innerText = "Arroz Carreteiro";
                        img.src = "misc/img/carreteiro.jpg";
                    }
                    break;
                case 'pacu_input':
                    if (radio_inputs[i].checked) {
                        image_tittle.innerText = "Pacu";
                        img.src = "misc/img/pacu.jpg";
                    }
                    break;
                case 'acaraje_input':
                    if (radio_inputs[i].checked) {
                        image_tittle.innerText = "Acarajé";
                        img.src = "misc/img/acaraje.jpg";
                    }
                    break;
                case 'cheese_bread_input':
                    if (radio_inputs[i].checked) {
                        image_tittle.innerText = "Cheese Bread";
                        img.src = "misc/img/cheese_bread.jpeg";
                    }
                    break;
                case 'arroz_bolinho_input':
                    if (radio_inputs[i].checked) {
                        image_tittle.innerText = "Bolinho de Arroz";
                        img.src = "misc/img/bolinho_de_arroz.jpeg";
                    }
                    break;
            }
        });
    }
}