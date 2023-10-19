package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.TerminalMenu;

public abstract class abstractDatabase {
    private String DATA_BASE_PATH;

    public void setDatabasePath(String path) {
        this.DATA_BASE_PATH = path;
    }

    public void checkDatabaseConnection() {
        try (Connection conn = DriverManager.getConnection(DATA_BASE_PATH)) {
            if (conn != null) {
                TerminalMenu.clearTerminal();
                System.out.println("Conexão com o banco de dados realizada com sucesso.\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getDatabaseConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATA_BASE_PATH);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void makeDataBase() throws SQLException {

        // Create users table
        String sql = "CREATE TABLE IF NOT EXISTS products (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "price REAL NOT NULL," +
                "quantity INTEGER NOT NULL," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "last_update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage()
                    + "Conexão com o banco de dados falhou, não foi possivel inicia-lo verifique a instalação das libs.");
        }
    }

    /**
     * Creates a something on the database
     * 
     * @param product Is an new instance of the product model class that is gonna be
     *                inserted on the database
     * @return a boolean with true or false, if the return is true everything is
     *         alright otherwise something went wrong.
     */
    public abstract boolean create(ProductsModel product) throws SQLException;

    /**
     * Updates something on the database
     * 
     * @param product Is an already created instance of the product model class that
     *                is gonna be
     *                updated using the setter inside the class then placed on the
     *                database
     * @return a boolean with true or false, if the return is true everything is
     *         alright otherwise something went wrong.
     */
    public abstract boolean update(ProductsModel product) throws SQLException;

    /**
     * Deletes something from the database
     * 
     * @param product Is an already created instance of the product model class that
     *                will be used to get the ID of the product on the database then
     *                use it to delete the data.
     * @return a boolean with true or false, if the return is true everything is
     *         alright otherwise something went wrong.
     */
    public abstract boolean delete(ProductsModel product) throws SQLException;

    /**
     * List one item from an certain table
     * 
     * @param Id from the item you want to see the data
     * @return print the item on the screen
     */
    public abstract void listItemsById(int Id) throws SQLException;

    /**
     * List all items from an certain table
     * 
     * @param Any
     * @return print all the items on the screen
     */
    public abstract void listAllItems() throws SQLException;
}
