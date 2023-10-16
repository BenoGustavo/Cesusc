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
        int userId = 0;
        ArrayList<String> credentials = new ArrayList<String>();
        Boolean exitProgram = false;
        String userChoice;
        DataBase dataBase = new DataBase();

        while (!exitProgram) {
            do {
                TerminalMenu.clearTerminal();
                userChoice = TerminalMenu.mainMenu();
            } while (!Utils.isUserInputValid(userChoice, TerminalMenu.MAIN_MENU_OPTIONS));

            switch (Utils.convertStringToInteger(userChoice)) {
                case 1:
                    // Login
                    credentials = TerminalMenu.loginMenu();
                    userId = dataBase.getUserIdByNameAndPassword(credentials.get(0), credentials.get(1));

                    // Checking login status
                    if (userId != 0) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed!");
                    }

                    break;
                case 2:

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