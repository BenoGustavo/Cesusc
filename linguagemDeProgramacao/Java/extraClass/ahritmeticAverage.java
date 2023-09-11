import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ahritmeticAverage {

    // function that calculates an ahritmeticAverage
    public static float doAhritmeticAverage(List<Float> listOfNumbers) {
        float ahritmeticAverage = 0;

        for (float number : listOfNumbers) {
            ahritmeticAverage += number;
        }

        ahritmeticAverage = ahritmeticAverage / listOfNumbers.size();

        return ahritmeticAverage;
    }

    public static void main(String[] args) {

        List<Float> listOfNumbers = new ArrayList<>();

        float result;
        String temp;
        try (Scanner input = new Scanner(System.in)) {
            Boolean doAgain = true;

            System.out.println("-=-=-=-Ahritmetic-Average-=-=-=-");

            do {
                System.out.println("\nAdd a number to the ahritmetic average or type {F} to see the results: ");
                temp = input.nextLine();

                if (temp.equalsIgnoreCase("f")) {
                    doAgain = false;
                }

                try {
                    if (doAgain) {

                        // Tranformando temp em float
                        float newFloatValue = Float.parseFloat(temp);
                        listOfNumbers.add(newFloatValue);

                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid float format: " + temp);
                }

                // Don't let the program finish if there isn't any number in the list
                if (listOfNumbers.size() == 0) {
                    System.out.println("Type something first...\n");
                    doAgain = true;
                }

            } while (doAgain);
        }
        result = doAhritmeticAverage(listOfNumbers);

        System.out.println("\nThe result of the ahritmetic-average of the list: " + listOfNumbers + " is\n" + result);

    }
}