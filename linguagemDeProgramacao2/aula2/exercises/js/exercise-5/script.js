calculateButton = document.getElementById('calculate_button');

calculateButton.addEventListener('click', calculateSalary);

function calculateSalary() {
    userName = document.getElementById('employee_name')
    hourValue = document.getElementById('hour_value')
    workedHours = document.getElementById('worked_hours')

    //Checks if the field is empty
    if (isFieldsEmpty(hourValue, workedHours, userName)) {
        alert('Please, fill all fields');
        return;
    }

    //get bonification
    const BONIFICATION = setBonification(workedHours.value)

    const FULL_SALARY = hourValue.value * workedHours.value;

    //get IRRF
    const IRRF = setIRRF(FULL_SALARY)

    //Calculates the salary
    const LIQUID_SALARY = (FULL_SALARY - (FULL_SALARY * IRRF)) + BONIFICATION;

    setResultsOnScreen(FULL_SALARY, IRRF, BONIFICATION, LIQUID_SALARY);

    return;
}

function isFieldsEmpty(fieldOne, FieldTwo, FieldThree) {
    if (fieldOne.value == '' || FieldTwo.value == '' || FieldThree.value == '') {
        return true;
    }
    return false;
}

function setIRRF(salary) {
    if (salary <= 2112) {
        return 0;
    } else if (salary >= 2112.1 && salary <= 2826.65) {
        return 0.075;
    } else if (salary >= 2826.66 && salary <= 3751.05) {
        return 0.15;
    } else if (salary >= 3751.06 && salary < 4664.68) {
        return 0.225;
    } else {
        return 0.275;
    }
}

// if the employee worked more than 100 hours, he will receive a bonification of 10% of the worked hours
function setBonification(workedHours) {
    if (workedHours < 100) {
        return 0;
    }

    return workedHours / 10
}

function setResultsOnScreen(fullSalary, IRRF, bonification, liquidSalary) {
    document.getElementById('full_salary').placeholder = fullSalary;
    document.getElementById('irrf').placeholder = (IRRF * 100) + "%";
    document.getElementById('bonification').placeholder = bonification;
    document.getElementById('liquid_salary').placeholder = liquidSalary;
}