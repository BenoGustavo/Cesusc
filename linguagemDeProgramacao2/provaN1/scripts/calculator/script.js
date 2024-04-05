let calculateButton = document.getElementById("calculate_button")

calculateButton.addEventListener('click', calculate);

function calculate(){
    const NAME = document.getElementById("employee_name").value
    const HOUR_VALUE = document.getElementById("hour_value").value
    const WORKED_HOURS = document.getElementById("worked_hours").value

    if(isFieldEmpty(NAME,HOUR_VALUE,WORKED_HOURS)){
        alert("COMPLETA AI 👍👏💋")
        return
    }

    const FULL_SALARY = HOUR_VALUE * WORKED_HOURS

    const INSS = getInss(FULL_SALARY)
    const IRRF = getIrrf(FULL_SALARY)
    const TAXA_FIXA = 0

    if(FULL_SALARY > 2212 && FULL_SALARY <= 2640){
        TAXA_FIXA = 528
    }

    const LIQUID_SALARY = FULL_SALARY - ((FULL_SALARY* IRRF) + (FULL_SALARY * INSS) + TAXA_FIXA)

    displayInformation(FULL_SALARY,IRRF,INSS,LIQUID_SALARY)
}

function getInss(FULL_SALARY){
    if(FULL_SALARY <= 1412){
        return 0.075
    }else if(FULL_SALARY >= 1412.01 && FULL_SALARY <= 2666.68){
        return 0.09
    }else if(FULL_SALARY >= 2666.69 && FULL_SALARY <= 4000.03){
        return 0.12
    }else if(FULL_SALARY > 4000.03){
        return 0.14
    }
}

function getIrrf(FULL_SALARY){
    if(FULL_SALARY >= 2640.01 && FULL_SALARY <= 2826.65){
        return 0.075
    }else if(FULL_SALARY >= 2826.66 && FULL_SALARY <= 3751.05){
        return 0.15
    }else if(FULL_SALARY >= 3751.06 && FULL_SALARY <= 4664.68){
        return 0.225
    }else if(FULL_SALARY > 4664.68){
        return 0.275
    }
    return 0
}

function isFieldEmpty(field1,field2,field3){
    if(field1.value === "" || field2.value === "" || field3.value === "" ){
        return true
    }
    return false
}

function displayInformation(fullSalary,irrf,inss,liquidSalary){
    let fullSalaryField = document.getElementById("full_salary")
    let irrfField = document.getElementById("irrf")
    let inssField = document.getElementById("INSS")
    let liquidSalaryField = document.getElementById("liquid_salary")

    fullSalaryField.placeholder = fullSalary
    irrfField.placeholder = (irrf * 100) + "%"
    inssField.placeholder = (inss * 100) + "%"
    liquidSalaryField.placeholder = liquidSalary
}