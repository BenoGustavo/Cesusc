import java.sql.SQLException;

import database.DataBase;
import utils.TerminalMenu;

// dataBase.createNewUser("John", 20, "John@gmail.com", "1234");
// dataBase.createNewProduct("MacBook Pro", 1000, "A laptop from Apple");
// dataBase.createNewOrder(1, 1);

class Main {
    public static void main(String[] args) throws SQLException {
        int userChoice;

        DataBase dataBase = new DataBase();

        do {
            userChoice = TerminalMenu.mainMenu();
        } while (!TerminalMenu.MAIN_MENU_OPTIONS.contains(userChoice));
    }
}