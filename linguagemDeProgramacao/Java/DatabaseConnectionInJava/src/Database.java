import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Database {
    private static final String DATA_BASE_PATH = "jdbc:sqlite:products.db";

    private void checkDatabaseConnection() {
        try (Connection conn = DriverManager.getConnection(DATA_BASE_PATH)) {
            if (conn != null) {
                System.out.println("Connection to SQLite has been established.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Database database = new Database();
        database.checkDatabaseConnection();
    }
}