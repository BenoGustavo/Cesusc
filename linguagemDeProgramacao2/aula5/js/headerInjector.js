fetch('/components/header.html')
    .then(response => response.text())
    .then(data => {
        // Get the element where you want to inject the HTML content
        const element = document.querySelector('body');

        // Inject the HTML content at the top of the body
        element.insertAdjacentHTML('afterbegin', data);
    })
    .catch(err => console.log(err));