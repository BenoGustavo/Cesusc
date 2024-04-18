let loginEmailInput = document.getElementById('login_email_field');
let loginPasswordInput = document.getElementById('login_password_field');

let registerEmailInput = document.getElementById('register_email_field');
let registerPasswordInput = document.getElementById('register_password_field');

let registerButton = document.getElementById('register_button');

let loginButton = document.getElementById('login_button');

registerButton.addEventListener('click', registerUser);
loginButton.addEventListener('click', loginUser);

function registerUser() {
    let user = {
        email: registerEmailInput.value,
        password: registerPasswordInput.value
    };

    let users = JSON.parse(localStorage.getItem('users')) || [];

    //Verifica se o email já está cadastrado
    if (users.find(u => u.email === user.email)) {
        alert('Usuário já cadastrado');
        return;
    }

    users.push(user);

    localStorage.setItem("users", JSON.stringify(users));

    alert('Usuário cadastrado com sucesso');
};

function loginUser() {
    let email = loginEmailInput.value;
    let password = loginPasswordInput.value;

    let users = JSON.parse(localStorage.getItem('users')) || [];
    let user = users.find(user => user.email === email && user.password === password);

    if (user) {
        alert('Usuario existe no local storage');
    } else {
        alert('Usuario não existe no local storage');
    }
}