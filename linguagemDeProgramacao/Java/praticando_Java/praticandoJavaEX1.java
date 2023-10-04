import java.io.IOException;
import java.util.Scanner;

public class praticandoJavaEX1 {

    public static void HelloWorld() {
        System.out.println("Hello World\n");
    }

    public static void questionOne(float ray) {
        System.out.println("Desenvolva um c\u00F3digo Java que solicite o raio de um c\u00EDrculo\r\n" + //
                "Em seguida o c\u00F3digo deve calcular a \u00E1rea do c\u00EDrculo\r\n" + //
                "Por fim deve apresentar para o usu\u00E1rio o resultado do c\u00EDrculo");

        System.out.println(3.14 * (ray * ray) + "\n");
    }

    public static void questionTwo() {
        // fiz um extra calculando o IMC

        int weight;
        float height, imc;
        String name;

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Insert your name: ");
            name = input.next();

            System.out.println("Insert your height in CM: ");
            height = input.nextInt();

            System.out.println("Insert your weight: ");
            weight = input.nextInt();
        }

        imc = weight / ((height / 100) * (height / 100));

        System.out.println("\n<=============================>");
        System.out.println("Your data:\n");
        System.out.println("Name: " + name);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("Your IMC is: " + imc + "\n");
    }

    public static void questionThree(float numberOne, float NumberTwo) {
        System.out.println("3.Soma dois valores num\u00E9ricos\r\n" + //
                "Cria um c\u00F3digo Java que solicite ao usu\u00E1rio dois n\u00FAmeros\r\n" + //
                "Em seguida some os dois valores informados e apresente o resultado");

        System.out.println("The sum is equals to " + (numberOne + NumberTwo) + "\n");
    }

    public static void questionFour(float numberOne, float NumberTwo) {
        float temp;
        System.out.println("O primeiro numero enviado é igual a " + numberOne + "\nO segundo numero enviado é igual a "
                + NumberTwo);

        temp = numberOne;
        numberOne = NumberTwo;
        NumberTwo = temp;

        System.out.println("\n\nAgora o primeiro numero enviado é igual a " + numberOne
                + "\nO segundo numero enviado é igual a " + NumberTwo);
    }

    // extra

    public static int sum(int numOne, int NumTwo) {
        return numOne + NumTwo;
    }

    public static int minus(int numOne, int NumTwo) {
        return numOne - NumTwo;
    }

    public static int division(int numOne, int NumTwo) {
        return numOne / NumTwo;
    }

    public static int multiplication(int numOne, int NumTwo) {
        return numOne * NumTwo;
    }

    public static void calculator() throws IOException {

        try (Scanner input = new Scanner(System.in)) {
            char[] operations = { '*', '/', '-', '+' };
            int firstNumber, secondNumber;
            String op;

            while (true) {
                System.out.println("Insert the first number: ");
                firstNumber = input.nextInt();

                System.out.println("\nInsert the second number: ");
                secondNumber = input.nextInt();

                System.out.print("\nInsert the operation (+,-,*,/): ");
                op = input.next();

                for (int i = 0; i <= operations.length; i++) {
                    if (op.charAt(0) == operations[i] && (op.length() == 1)) {

                        switch (op) {
                            case "+":
                                System.out.println(sum(firstNumber, secondNumber) + "\n");
                                break;
                            case "-":
                                System.out.println(minus(firstNumber, secondNumber) + "\n");
                                break;
                            case "*":
                                System.out.println(multiplication(firstNumber, secondNumber) + "\n");
                                break;
                            case "/":
                                System.out.println(division(firstNumber, secondNumber) + "\n");
                                break;
                        }

                        break;
                    }
                }

            }
        }

    }

    public static void main(String[] args) {
        try {

            // HelloWorld();

            // questionOne(1);

            // questionTwo();

            // questionThree(1, 1);

            // questionFour(1, 2);

            // calculator();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
