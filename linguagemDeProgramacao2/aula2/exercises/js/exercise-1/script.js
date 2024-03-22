let name_field = document.getElementById('name');
let email_field = document.getElementById('email');
let telephone_number_field = document.getElementById('telephone_number');
let mensage_field = document.getElementById('message');

let send_button = document.getElementById('send_input');
send_button.addEventListener('click', send);

function send() {
    if (name_field.value == "" || email_field.value == "" || telephone_number_field.value == "" || mensage_field.value == "") {
        alert("Please, fill all the fields.");
    } else {
        alert("Message sucessfully sent!");
    }
}