import java.util.Scanner;

public class praticandoJavaEX2 {

    public static void firstQuestion() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println(
                    "1. Concatenação Invertida ● Crie um programa que peça ao usuário para inserir duas strings. Em seguida, concatene as strings de forma invertida, ou seja, primeiro a segunda string e depois a primeira string.\n");

            System.out.println("Insert the first string: ");
            String firstString = input.nextLine();

            System.out.println("\nInsert the second string: ");
            String secondString = input.nextLine();

            String concatedString = secondString.concat(firstString);
            System.out.println("Your concatened string " + concatedString + "\n");
        }

    }

    public static void secondQuestion() {
        String userFirstChar = "zczsdad", userSecondChar = "", newString = "";

        try (Scanner input = new Scanner(System.in)) {
            System.out.println(
                    "2. Substituição de Caracteres ● Peça ao usuário para inserir uma string e dois caracteres. Substitua todas as ocorrências do primeiro caractere pelo segundo caractere na string, utilizando apenas métodos da classe String.\n");

            System.out.println("Insert the string you desire to change: ");
            String userString = input.nextLine();

            while (userFirstChar.length() > 1 || userSecondChar.length() > 1) {
                System.out.println("\nInsert the first char: ");
                userFirstChar = input.nextLine();

                System.out.println("\nInsert the second char: ");
                userSecondChar = input.nextLine();

                if (userFirstChar.length() > 1 || userSecondChar.length() > 1) {
                    System.out.println("Chars need to have only one letter");
                }
            }

            newString = userString.replace(userFirstChar, userSecondChar);
        }

        System.out.println("Your new string is " + newString + "\n");

    }

    public static void thirdQuestion() {
        String[] vogais = { "a", "e", "i", "o", "u" };
        String userChar = "y", newString = "";

        try (Scanner input = new Scanner(System.in)) {
            System.out.println(
                    "3. Troca de Vogais ● Peça ao usuário para inserir uma string. Em seguida, crie uma nova string onde todas as vogais são trocadas por um caractere escolhido pelo usuário (exceto o caractere 'y'). Utilize o método replace() para realizar a troca.\n");

            System.out.println("Insert the string: ");
            String userString = input.nextLine();

            while (userChar.equals("y") || userChar.length() > 1) {
                System.out.println("\nInsert the char you want: ");
                userChar = input.nextLine();

                if (userChar.equals("y")) {
                    System.out.println("\nYour can't put the Y there =((((( )");
                }
                if (userChar.length() > 1) {
                    System.out.println("\nA char have only one letter... )");
                }
            }

            for (int i = 0; i < vogais.length; i++) {
                newString = userString.replace(vogais[i], userChar);
                userString = newString;
            }
        }

        System.out.println("\nYour new string is " + newString);

    }

    public static void main(String[] args) {
        // firstQuestion();

        // secondQuestion();

        // thirdQuestion();
    }
}
