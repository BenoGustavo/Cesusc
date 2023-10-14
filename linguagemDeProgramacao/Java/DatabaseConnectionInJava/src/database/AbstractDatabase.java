package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract class AbstractDatabase {
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
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "age INTEGER NOT NULL," +
                "email TEXT NOT NULL," +
                "password TEXT NOT NULL" +
                ");";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.execute();
        }

        // Create products table
        sql = "CREATE TABLE IF NOT EXISTS products (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "price REAL NOT NULL," +
                "description TEXT NOT NULL" +
                ");";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.execute();
        }

        // Create orders table
        sql = "CREATE TABLE IF NOT EXISTS orders (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "user_id INTEGER NOT NULL," +
                "product_id INTEGER NOT NULL," +
                "FOREIGN KEY (user_id) REFERENCES users(id)," +
                "FOREIGN KEY (product_id) REFERENCES products(id)" +
                ");";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.execute();
        }
    }

    // Abstract methods for the user
    public abstract void createNewUser(String name, int age, String email, String password) throws SQLException;

    public abstract void updateUser(int id, String name, int age, String email, String password) throws SQLException;

    public abstract void deleteUser(int id) throws SQLException;

    public abstract void showUserById(int id) throws SQLException;

    // Abstract methods for the product
    public abstract void createNewProduct(String name, double price, String description) throws SQLException;

    public abstract void updateProduct(int id, String name, double price, String description) throws SQLException;

    public abstract void deleteProduct(int id) throws SQLException;

    public abstract void showProductById(int id) throws SQLException;

    // Abstract methods for the order
    public abstract void createNewOrder(int userId, int productId) throws SQLException;

    public abstract void updateOrder(int id, int userId, int productId) throws SQLException;

    public abstract void deleteOrder(int id) throws SQLException;

    // Abstract methods for the show
    public abstract void showAllUsers() throws SQLException;

    public abstract void showAllProducts() throws SQLException;

    public abstract void showAllOrdersFromUser(int userId) throws SQLException;

    public abstract int getUserIdByNameAndPassword(String name, String password) throws SQLException;
}
