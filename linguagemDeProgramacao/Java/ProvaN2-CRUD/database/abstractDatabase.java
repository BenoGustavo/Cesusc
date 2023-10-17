package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.product.ProductsModel;

public abstract class abstractDatabase {
    private String DATA_BASE_PATH;

    public void setDatabasePath(String path) {
        this.DATA_BASE_PATH = path;
    }

    public void checkDatabaseConnection() {
        try (Connection conn = DriverManager.getConnection(DATA_BASE_PATH)) {
            if (conn != null) {
                System.out.println("Connection to SQLite has been established.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getDatabaseConnection() {
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
        String sql = "CREATE TABLE IF NOT EXISTS produtos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "price REAL NOT NULL," +
                "quantity INTEGER NOT NULL" +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "last_update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.execute();
        }
    }

    /**
     * Creates a something on the database
     * 
     * @param
     * @return a boolean with true or false, if the return is true everything is
     *         alright otherwise something went wrong.
     */
    public abstract boolean create(ProductsModel product) throws SQLException;

    /**
     * Updates something on the database
     * 
     * @param
     * @return a boolean with true or false, if the return is true everything is
     *         alright otherwise something went wrong.
     */
    public abstract boolean update(ProductsModel product) throws SQLException;

    /**
     * Deletes something from the database
     * 
     * @param
     * @return a boolean with true or false, if the return is true everything is
     *         alright otherwise something went wrong.
     */
    public abstract String delete(int Id) throws SQLException;

    /**
     * List one item from an certain table
     * 
     * @param Id from the item you want to get
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
