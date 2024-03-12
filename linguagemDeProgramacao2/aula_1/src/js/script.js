window.onload = function () {
    document.querySelector("#send__button").addEventListener('click', function (event) {
        // Prevent the button's default click action
        event.preventDefault();

        // Get the form data
        var formData = new FormData(document.forms["main__form"]);

        // Get the table where you want to add the new cell
        var table = document.querySelector("#main__table");

        // Create a new row
        var row = document.createElement("tr");

        // Convert formData to an array so we can access its length
        var formDataArray = Array.from(formData.entries());

        // Go through each form data entry
        for (var i = 0; i < formDataArray.length; i++) {
            var pair = formDataArray[i];

            // Create a new cell
            var cell = document.createElement("td");

            if (i === formDataArray.length - 1) {
                // If it's the last item, create a color input
                var input = document.createElement("input");
                input.type = "color";
                input.value = pair[1];
                input.disabled = true;
                cell.appendChild(input);
            } else {
                // Set the cell text to the form data
                cell.textContent = pair[1];
            }

            // Add the cell to the row
            row.appendChild(cell);
        }

        // Add the row to the table
        table.appendChild(row);
    });
};