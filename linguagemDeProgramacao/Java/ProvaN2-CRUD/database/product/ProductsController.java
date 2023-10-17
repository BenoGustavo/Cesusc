package database.product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import database.abstractDatabase;

/**
 * This class controls the interaction between the products and the database
 */
public class ProductsController extends abstractDatabase {

    private ArrayList<ProductsModel> products = new ArrayList<ProductsModel>();

    public ArrayList<ProductsModel> loadDataBase() throws SQLException {
        String sql = "SELECT * FROM products;";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                Timestamp creationDate = resultSet.getTimestamp("created_at");
                Timestamp lastUpdateDate = resultSet.getTimestamp("last_update_at");

                ProductsModel product = new ProductsModel(id, name, price, quantity, creationDate, lastUpdateDate);

                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return products;
    }

    // Constructor Overloading with and without database path
    public ProductsController(String path) throws SQLException {
        setDatabasePath(path);
        makeDataBase();

        // Load the database in to a list
        this.products = loadDataBase();
    }

    public ProductsController() throws SQLException {
        setDatabasePath("jdbc:sqlite:src/database/users_and_products.db");
        makeDataBase();
    }

    @Override
    public boolean create(ProductsModel product) throws SQLException {
        String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?);";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setTimestamp(4, product.getCreationDate());
            statement.setTimestamp(5, product.getLastTimeUpdated());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(ProductsModel product) throws SQLException {
        String sql = "UPDATE products SET name = ?, price = ?, quantity = ?, last_update_at = ? WHERE id = ?";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setTimestamp(5, product.getCreationDate());
            statement.setInt(6, product.getId());
            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String delete(int Id) throws SQLException {
        String productName = "not found";
        String sql = "SELECT * FROM products WHERE id = ?";

        ResultSet queryResult = null;

        // Get the product name to show on the return message and checks if the product
        // exists on the database
        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setInt(1, Id);

            queryResult = statement.executeQuery();

            if (queryResult == null) {
                throw new SQLException("Product not found!");
            }

            productName = queryResult.getString("name");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "DELETE FROM products WHERE id = ?";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setInt(1, Id);

            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Product " + productName + " deleted!";
    }

    @Override
    public void listItemsById(int Id) throws SQLException {
        String sql = "SELECT * FROM products WHERE id = ?;";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            System.out.println("\n----- PRODUCT " + resultSet.getString("name") + " -----");
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("name");
            double preco = resultSet.getDouble("price");
            int quantidade = resultSet.getInt("quantity");
            Timestamp creationDate = resultSet.getTimestamp("created_at");
            Timestamp lastUpdateDate = resultSet.getTimestamp("last_update_at");

            System.out.println("ID: " + id);
            System.out.println("NAME: " + nome);
            System.out.println("PRICE: R$ " + preco);
            System.out.println("QUANTITY: " + quantidade);
            System.out.println("CREATED AT: " + creationDate);
            System.out.println("LAST UPDATE AT: " + lastUpdateDate);
        }
    }

    @Override
    public void listAllItems() throws SQLException {
        String sql = "SELECT * FROM products;";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            System.out.println("\n----- PRODUCTS LIST -----");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("name");
                double preco = resultSet.getDouble("price");
                int quantidade = resultSet.getInt("quantity");
                Timestamp creationDate = resultSet.getTimestamp("created_at");
                Timestamp lastUpdateDate = resultSet.getTimestamp("last_update_at");

                System.out.println("ID: " + id);
                System.out.println("NAME: " + nome);
                System.out.println("PRICE: R$ " + preco);
                System.out.println("QUANTITY: " + quantidade);
                System.out.println("CREATED AT: " + creationDate);
                System.out.println("LAST UPDATE AT: " + lastUpdateDate);
                System.out.println("-----------------------");
            }
        }
    }
}
