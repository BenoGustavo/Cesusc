let selectedQuestions = [];

fetch('misc/json/questions.json')
    .then(function (response) {
        if (!response.ok) {
            throw new Error("HTTP error " + response.status);
        }
        return response.json();
    })
    .then(function (json) {
        let selectedIndices = new Set();
        while (selectedQuestions.length < 5) {
            let randomIndex = Math.floor(Math.random() * json.length);
            if (!selectedIndices.has(randomIndex)) {
                selectedIndices.add(randomIndex);
                selectedQuestions.push(json[randomIndex]);
            }
        }
        displayQuestions();
        displayAnswers();
    })
    .catch(function () {
        alert("An error occurred while fetching the JSON file, the quiz may not work.");
    });

function displayQuestions() {
    let questionsDiv = document.getElementsByClassName('question');

    for (let i = 0; i < selectedQuestions.length; i++) {
        questionsDiv[i].querySelector('label').innerHTML = selectedQuestions[i]["question"];
    }
}

function displayAnswers() {
    let asnwersKeys = ['A', 'B', 'C', 'D'];
    let selectors = document.getElementsByName('question_answers');

    selectors.forEach(function (select, questionIndex) {
        for (let i = 0; i < select.options.length; i++) {
            let option = select.options[i];
            option.innerHTML = selectedQuestions[questionIndex][asnwersKeys[i]];
        }
    });
}