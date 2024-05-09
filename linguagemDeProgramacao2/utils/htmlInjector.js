// Description: This file is used to inject the some html file into the body of other file.
fetch("Path to the HTML file you want to inject")
    .then(response => response.text())
    .then(data => {
        // Get the element where you want to inject the HTML content
        const element = document.querySelector('body');

        // Inject the HTML content at the top of the body
        element.insertAdjacentHTML('afterbegin', data);

        // Inject the HTML content at the bottom of the body
        // element.insertAdjacentHTML('beforeend', data);

        // Inject the HTML content before the element
        // element.insertAdjacentHTML('beforebegin', data);

        // Inject the HTML content after the element
        // element.insertAdjacentHTML('afterend', data);

    })
    .catch(err => console.log(err));