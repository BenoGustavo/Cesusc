import java.util.Scanner;

public class tabuada {
    public static void doMultiplicationTable(float number) {
        for (int i = 0; i < 11; i++) {
            System.out.println(number + "x" + i + '=' + number * i);
        }
    }

    public static void main(String[] args) {
        String numberStr;
        try (Scanner input = new Scanner(System.in)) {
            try {
                System.out.println("Insert whatever number you wish: ");
                numberStr = input.nextLine();
                float floatValue = Float.parseFloat(numberStr);

                doMultiplicationTable(floatValue);

            } catch (NumberFormatException e) {
                System.out.println("\nThe string is not a valid float.");
            }
        }
    }
}
