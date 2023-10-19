import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import utils.TerminalMenu;
import database.ProductsController;
import database.ProductsModel;
import utils.Utils;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws SQLException {
        Boolean isProgramRunning = true;

        int userSelection, productID;
        ArrayList<String> productData;
        ProductsModel productToUpdate, productToDelete;

        @SuppressWarnings("resource")
        Scanner userInput = new Scanner(System.in);
        ProductsController Product = new ProductsController();

        // LOOPS THE APLICATION
        do {
            // CATCH INPUT ERROR FROM THE USER AND SEND THEM BACK TO THE MENU
            try {
                Product.checkDatabaseConnection();
                userSelection = TerminalMenu.mainMenu();

                switch (userSelection) {
                    // create
                    case 1 -> {
                        productData = TerminalMenu.askForProductDataMenu("Criar novo produto no sistema");

                        // Creates a new product object
                        ProductsModel newProduct = new ProductsModel(productData.get(0),
                                Double.parseDouble(productData.get(1)),
                                Integer.parseInt(productData.get(2)));

                        // Create a new product and check if it was created successfully
                        if (Product.create(newProduct)) {
                            System.out.println("\nProduto cadastrado com sucesso!");
                            System.out.print("Aperte qualquer tecla para continuar: ");
                            userInput.nextLine();
                        } else {
                            System.out.println("\nErro ao cadastrar produto!");
                            System.out.print("Aperte qualquer tecla para continuar: ");
                            userInput.nextLine();
                        }
                    }

                    // read
                    case 2 -> {
                        userSelection = TerminalMenu.readProductMenu();

                        switch (userSelection) {
                            // List all the products on the database
                            case 1 -> Product.listAllItems();

                            // list a product based on an ID
                            case 2 -> {
                                productID = TerminalMenu.askForAnID("Listar produto por ID");

                                if (Utils.findProduct(Product.getProductList(), productID) != null) {
                                    Product.listItemsById(productID);
                                } else {
                                    TerminalMenu.productNotFoundWarning();
                                }
                            }

                            // return to main menu
                            case 3 -> {
                                break;
                            }

                            default -> TerminalMenu.invalidOption();
                        }
                    }

                    // update
                    case 3 -> {
                        productID = TerminalMenu.askForAnID("Atualizar um produto");

                        productToUpdate = Utils.findProduct(Product.getProductList(), productID);

                        if (productToUpdate != null) {

                            productData = TerminalMenu.askForProductDataMenu("Atualizar um produto");
                            productToUpdate.setName(productData.get(0));
                            productToUpdate.setPrice(Double.parseDouble(productData.get(1)));
                            productToUpdate.setQuantity(Integer.parseInt(productData.get(2)));

                            if (Product.update(productToUpdate)) {
                                System.out.println("\nProduto atualizado com sucesso");
                                System.out.print("Aperte qualquer tecla para continuar: ");
                                userInput.nextLine();
                            } else {
                                System.out.println("\nFalha ao atualizar o produto");
                                System.out.print("Aperte qualquer tecla para continuar: ");
                                userInput.nextLine();
                            }

                        } else {
                            TerminalMenu.productNotFoundWarning();
                        }
                    }

                    // // delete
                    case 4 -> {
                        productID = TerminalMenu.askForAnID("Deletar produto");

                        productToDelete = Utils.findProduct(Product.getProductList(), productID);

                        if (productToDelete != null) {
                            Product.delete(productToDelete);
                        } else {
                            TerminalMenu.productNotFoundWarning();
                        }
                    }

                    // exit
                    case 5 -> isProgramRunning = false;

                    // Invalid option
                    default -> TerminalMenu.invalidOption();
                }

                // catching some errors
            } catch (IllegalArgumentException e) {
                System.out.println("\nErro: " + e.getMessage());
                System.out.print("Aperte qualquer tecla para continuar: ");
                userInput.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("\nErro: " + "Entrada inválida! Tente novamente.");
                System.out.print("Aperte qualquer tecla para continuar: ");
                userInput.nextLine();

            } catch (Exception e) {
                System.out.println("\nErro: " + "Erro deconhecido!" + e + "Tente novamente.");
                System.out.print("Aperte qualquer tecla para continuar: ");
                userInput.nextLine();
            }

        } while (isProgramRunning);
    }
}