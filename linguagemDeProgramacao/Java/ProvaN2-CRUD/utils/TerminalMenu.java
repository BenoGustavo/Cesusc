package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalMenu {
    public static int mainMenu() {
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("\n----- Sistema de Gerenciamento de Produtos -----");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            return userInput.nextInt();
        }
    }

    public static ArrayList<String> createProductMenu() {
        ArrayList<String> productData = new ArrayList<String>();

        try (Scanner userInput = new Scanner(System.in)) {
            userInput.nextLine();

            System.out.print("\nNome do Produto: ");
            String productName = userInput.nextLine();

            System.out.print("Preço do Produto: ");
            String productPrice = userInput.nextLine();

            System.out.print("Quantidade do Produto: ");
            String productQuantity = userInput.nextLine();

            productData.add(productName);
            productData.add(productPrice);
            productData.add(productQuantity);

            return productData;
        }
    }
}
