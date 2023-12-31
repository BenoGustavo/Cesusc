package com.controleestoque.connection.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * This class controls the interaction between the products and the database
 */
public class ProductsController extends abstractDatabase {

    // Constructor Overloading with and without database path
    public ProductsController(String path) throws SQLException {
        setDatabasePath("jdbc:sqlite:" + path);
        makeDataBase();

        // Load the database in to a list
        this.products = loadDataBase();
    }

    // Default constructor
    public ProductsController() throws SQLException {
        setDatabasePath("jdbc:sqlite:database/Database.db");
        makeDataBase();

        // Load the database in to a list
        this.products = loadDataBase();
    }

    private ArrayList<ProductsModel> products = new ArrayList<ProductsModel>();

    public ArrayList<ProductsModel> getProductList() {
        return this.products;
    }

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

    private int getLastIdFromDb() {
        String sql = "SELECT id FROM products ORDER BY id DESC LIMIT 1;";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            return resultSet.getInt("id");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean create(ProductsModel product) throws SQLException {
        String sql = "INSERT INTO products (name, price, quantity,created_at,last_update_at) VALUES (?, ?, ?, ?, ?);";
        int lastID;

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setTimestamp(4, product.getCreationDate());
            statement.setTimestamp(5, product.getLastTimeUpdated());
            statement.executeUpdate();

            // setting the id on the product
            lastID = this.getLastIdFromDb();
            product.setId(lastID);

            // add the new product to the list
            this.products.add(product);

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
            statement.setTimestamp(4, product.getLastTimeUpdated());
            statement.setInt(5, product.getId());
            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(ProductsModel product) throws SQLException {
        String sql = "SELECT * FROM products WHERE id = ?";

        sql = "DELETE FROM products WHERE id = ?";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setInt(1, product.getId());

            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // removing from the list of products
        int index = -1;
        for (int i = 0; i < products.size(); i++) {

            // finding the correct item to remove
            if (products.get(i).getId() == product.getId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            products.remove(index);
        }
        return true;
    }

    public ProductsModel findProduct(ArrayList<ProductsModel> listOfProducts, int id) {

        for (ProductsModel Product : listOfProducts) {
            if (Product.getId() == id) {
                return Product;
            }
        }
        return null;
    }
}
