package utils;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class TerminalMenu {

    public final static ArrayList<Integer> MAIN_MENU_OPTIONS = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    public final static ArrayList<Integer> USERS_MENU_OPTIONS = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
    public final static ArrayList<Integer> PRODUCTS_MENU_OPTIONS = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    public final static ArrayList<Integer> ORDERS_MENU_OPTIONS = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));

    public static int mainMenu() {
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("-=-=-Order-Manager-=-=-\n");
            System.out.println("1 - Login");
            System.out.println("2 - Manage users");
            System.out.println("3 - Manage products");
            System.out.println("4 - Manage orders");
            System.out.println("5 - Exit");

            return userInput.nextInt();
        }
    }

    public static int usersMenu() {
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("-=-=-Users-=-=-\n");
            System.out.println("1 - Create new user");
            System.out.println("2 - Update user");
            System.out.println("2 - Delete user");
            System.out.println("3 - Show all users");
            System.out.println("4 - Back");

            return userInput.nextInt();
        }
    }

    public static int productsMenu() {
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("-=-=-Products-=-=-\n");
            System.out.println("1 - Create new product");
            System.out.println("2 - Delete product");
            System.out.println("3 - Update product");
            System.out.println("4 - Show all products");
            System.out.println("5 - Back");

            return userInput.nextInt();
        }
    }

    public static int ordersMenu() {
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("-=-=-Orders-=-=-\n");
            System.out.println("1 - Create new order");
            System.out.println("2 - Delete order");
            System.out.println("3 - Your orders");
            System.out.println("4 - Show all orders");
            System.out.println("5 - Back");

            return userInput.nextInt();
        }
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
