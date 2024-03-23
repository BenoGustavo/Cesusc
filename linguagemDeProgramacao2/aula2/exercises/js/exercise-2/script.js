const buttons = document.querySelectorAll('.calculator button');

let display = document.getElementById('display');
let isCalculated = false;

// Now you can loop over the buttons
buttons.forEach(button => {
    if (button.id == "=") {
        button.addEventListener("click", calculate);
    } else if (button.id == "←") {
        button.addEventListener("click", eraseLastCharacter);
    } else if (button.id == "C") {
        button.addEventListener("click", cleanDisplay)
    } else {
        button.addEventListener("click", sendToDisplay);
    }
});

function cleanDisplay() {
    display.value = "";
    return;
}

function isOperator(operator) {
    if (operator == "+" || operator == "-" || operator == "*" || operator == "/") {
        return true;
    }
    return false;

}

function isLastCharacterOperator() {
    let lastCharacter = display.value.slice(-1);

    return isOperator(lastCharacter);

}

function isDisplayEmpty() {
    if (display.value == "") {
        return true;
    }
    return false;

}

function sendToDisplay() {
    if (isCalculated) {
        cleanDisplay();
        isCalculated = false;
    }

    if (isLastCharacterOperator() && isOperator(this.id)) {
        return;
    }

    if (isDisplayEmpty() && isOperator(this.id)) {
        return;
    }

    display.value += this.id;
}

function calculate() {
    //REMOVING THE LAST CHARACTER IF IT'S AN OPERATOR BECAUSE THE USER IS DUMB AND DOESN'T KNOW HOW TO USE A CALCULATOR
    if (isLastCharacterOperator()) {
        display.value = display.value.slice(0, -1);
    }

    // THIS LINE OF CODE IS UNSECURE AF
    display.value = eval(display.value)

    isCalculated = true;
}

function eraseLastCharacter() {
    display.value = display.value.slice(0, -1);
}