package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class TerminalMenu {

    public final static ArrayList<Integer> MAIN_MENU_OPTIONS = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    public final static ArrayList<Integer> USERS_MENU_OPTIONS = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
    public final static ArrayList<Integer> PRODUCTS_MENU_OPTIONS = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    public final static ArrayList<Integer> ORDERS_MENU_OPTIONS = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));

    public static String mainMenu() throws IOException {
        System.out.println("-=-=-Order-Manager-=-=-\n");
        System.out.println("1 - Login");
        System.out.println("2 - Manage users");
        System.out.println("3 - Manage products");
        System.out.println("4 - Manage orders");
        System.out.println("5 - Exit");

        // Read and return user input
        try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            return userInput.readLine();
        }
    }

    public static ArrayList<String> loginMenu() throws IOException {
        String username;
        String password;

        System.out.println("-=-=-Login-=-=-\n");
        System.out.println("Enter user: ");

        try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            username = userInput.readLine();
        }

        System.out.println("Enter password: ");

        try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            password = userInput.readLine();
        }

        ArrayList<String> credentials = new ArrayList<String>();
        credentials.add(username);
        credentials.add(password);

        return credentials;
    }

    public static String usersMenu() throws IOException {
        System.out.println("-=-=-Users-=-=-\n");
        System.out.println("1 - Create new user");
        System.out.println("2 - Update user");
        System.out.println("2 - Delete user");
        System.out.println("3 - Show all users");
        System.out.println("4 - Back");

        // Read and return user input
        try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            return userInput.readLine();
        }
    }

    public static String productsMenu() throws IOException {
        System.out.println("-=-=-Products-=-=-\n");
        System.out.println("1 - Create new product");
        System.out.println("2 - Delete product");
        System.out.println("3 - Update product");
        System.out.println("4 - Show all products");
        System.out.println("5 - Back");
        try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            return userInput.readLine();
        }
    }

    public static String ordersMenu() throws IOException {
        System.out.println("-=-=-Orders-=-=-\n");
        System.out.println("1 - Create new order");
        System.out.println("2 - Delete order");
        System.out.println("3 - Your orders");
        System.out.println("4 - Show all orders");
        System.out.println("5 - Back");

        try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            return userInput.readLine();
        }
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
