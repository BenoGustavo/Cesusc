import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DataBase;
import utils.TerminalMenu;
import utils.Utils;

// dataBase.createNewUser("John", 20, "John@gmail.com", "1234");
// dataBase.createNewProduct("MacBook Pro", 1000, "A laptop from Apple");
// dataBase.createNewOrder(1, 1);

class Main {
    public static void main(String[] args) throws SQLException, IOException {

        // Variables

        // userInfos
        int userId = 0;
        String deleteUserId = 0;
        ArrayList<String> credentials = new ArrayList<String>();
        ArrayList<String> userData = new ArrayList<String>();
        ArrayList<String> newUserData = new ArrayList<String>();

        // booleans
        Boolean exitProgram = false, exitUsersMenu = false;

        // UserSelection
        String userChoice;

        // create database
        DataBase dataBase = new DataBase();

        // Main loop
        while (!exitProgram) {
            // Resetting variables
            exitUsersMenu = false;

            do {
                userData = dataBase.showUserById(userId);

                TerminalMenu.whoIsLoggedIn(userData);
                userChoice = TerminalMenu.mainMenu();
            } while (!Utils.isUserInputValid(userChoice, TerminalMenu.MAIN_MENU_OPTIONS));

            switch (Utils.convertStringToInteger(userChoice)) {
                case 1:
                    // Login
                    credentials = TerminalMenu.loginMenu();
                    userId = dataBase.getUserIdByNameAndPassword(credentials.get(0), credentials.get(1));

                    // Checking login status
                    if (userId != 0) {
                        System.out.println("\nLogin successful!");

                        try {
                            Thread.sleep(2000); // Pause for 5 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("\nLogin failed!");

                        try {
                            Thread.sleep(2000); // Pause for 5 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
                case 2:
                    // Manage users
                    // user menu loop
                    while (!exitUsersMenu) {
                        do {
                            userChoice = TerminalMenu.usersMenu();
                        } while (!Utils.isUserInputValid(userChoice, TerminalMenu.USERS_MENU_OPTIONS));

                        switch (Utils.convertStringToInteger(userChoice)) {
                            case 1:
                                // create new user
                                newUserData = TerminalMenu.createNewUserMenu();

                                dataBase.createNewUser(newUserData.get(0),
                                        Utils.convertStringToInteger(newUserData.get(1)),
                                        newUserData.get(2), newUserData.get(3));
                                break;
                            case 2:
                                // update user
                                // Preguiça de fazer
                                break;
                            case 3:
                                // delete user
                                // deleteUserId = TerminalMenu.deleteUserMenu();
                                // dataBase.deleteUser(Utils.convertStringToInteger());
                                break;
                            case 4:
                                exitUsersMenu = true;
                                break;

                            default:
                                break;
                        }
                    }

                    break;
                case 3:

                    break;
                case 4:

                    break;

                case 5:
                    exitProgram = true;
                    break;

                default:
                    break;
            }
        }
    }
}