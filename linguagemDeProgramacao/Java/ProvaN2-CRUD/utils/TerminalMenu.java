package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalMenu {
    public static int mainMenu() {
        Scanner userInput = new Scanner(System.in);

        clearTerminal();

        System.out.println("\n----- Sistema de Gerenciamento de Produtos -----");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Atualizar Produto");
        System.out.println("4 - Deletar Produto");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
        return userInput.nextInt();
    }

    public static void productNotFoundWarning() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("\nProduto não encontrado...");
        System.out.print("Aperte qualquer tecla para continuar: ");
        userInput.nextLine();
    }

    public static int askForAnID(String segmentName) {
        Scanner userInput = new Scanner(System.in);
        clearTerminal();

        System.out.println("----- " + segmentName + " -----\n");
        System.out.print("Digite o ID do produto: ");

        return userInput.nextInt();
    }

    public static ArrayList<String> askForProductDataMenu(String segment) {
        ArrayList<String> productData = new ArrayList<String>();

        Scanner userInput = new Scanner(System.in);

        clearTerminal();
        System.out.println("----- " + segment + " -----\n");

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

    public static int readProductMenu() {
        Scanner userInput = new Scanner(System.in);

        clearTerminal();
        System.out.println("----- Listar produtos do sistema -----\n");

        System.out.println("1 - Listar todos os produtos");
        System.out.println("2 - Listar Produto por ID");
        System.out.print("Escolha uma opção: ");
        int op = userInput.nextInt();

        return op;
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void invalidOption() {
        Scanner userInput = new Scanner(System.in);

        clearTerminal();
        System.out.println("\nOpção inválida...");
        System.out.print("Aperte qualquer tecla para continuar: ");
        userInput.nextLine();
    }
}
