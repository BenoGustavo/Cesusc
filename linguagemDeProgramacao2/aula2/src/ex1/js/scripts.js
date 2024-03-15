let feedbackMessage = document.querySelector("#feedback")
let sendButton = document.querySelector("#send_button")

i = 0
function sendFormToSpace(){
    i+=1
    let form = document.getElementsByClassName("form__container")
    for(let i=0;i<form.length;i++){
        
        let formInputs = form[i].getElementsByTagName("input");
    
        // Iterate over inputs within the current form container
        for (let j = 0; j < formInputs.length; j++) {
            console.log(formInputs[j].value); // Access input value
        }
    }

    feedbackMessage.innerHTML = `You clicked on the button ${i} times`
}