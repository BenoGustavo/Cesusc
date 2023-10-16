package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataBase extends AbstractDatabase {

    public DataBase(String path) throws SQLException {
        setDatabasePath(path);
        makeDataBase();
    }

    public DataBase() throws SQLException {
        setDatabasePath("jdbc:sqlite:src/database/users_and_products.db");
        makeDataBase();
    }

    @Override
    public void showAllUsers() throws SQLException {
        String sql = "SELECT * FROM users";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.execute();
        }
    }

    @Override
    public void createNewUser(String name, int age, String email, String password) {
        String sql = "INSERT INTO users(name, age, email, password) VALUES(?,?,?,?)";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, email);
            statement.setString(4, password);

            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateUser(int id, String name, int age, String email, String password) {
        // TODO
    }

    @Override
    public String deleteUser(int id) {
        String username;
        String sql = "SELECT * FROM users WHERE id = ?";

        ResultSet queryResult = null;
        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setInt(1, id);

            queryResult = statement.executeQuery();

            if (queryResult == null) {
                return "User not found!";
            }

            username = queryResult.getString("name");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Database Connetion error!";
        }

        sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Database Connetion error!";
        }
        return "User " + username + " deleted!";
    }

    @Override
    public ArrayList<String> showUserById(int id) throws SQLException {
        ArrayList<String> user = new ArrayList<>();

        if (id == 0) {
            return user;
        }

        String sql = "SELECT * FROM users WHERE id = ?";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setInt(1, id);

            ResultSet queryResult = statement.executeQuery();

            if (queryResult != null) {
                int userId = queryResult.getInt("id");
                String name = queryResult.getString("name");
                String email = queryResult.getString("email");
                String password = queryResult.getString("password");

                user.add(String.valueOf(userId));
                user.add(name);
                user.add(email);
                user.add(password);

                return user;
            }

            return user;
        }
    }

    @Override
    public void createNewProduct(String name, double price, String description) {
        String sql = "INSERT INTO products(name, price, description) VALUES(?,?,?)";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql);) {
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setString(3, description);

            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateProduct(int id, String name, double price, String description) {
        // TODO
    }

    @Override
    public void deleteProduct(int id) {
        // TODO
    }

    @Override
    public void showProductById(int id) {
        // TODO
    }

    @Override
    public void createNewOrder(int userId, int productId) {

        // checks if the user exists
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setInt(1, userId);

            if (statement.executeQuery() == null) {
                System.out.println("User not found!");
                return;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // checks if the product exists
        sql = "SELECT * FROM products WHERE id = ?";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setInt(1, productId);

            if (statement.executeQuery() == null) {
                System.out.println("Product not found!");
                return;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // Create the order
        sql = "INSERT INTO orders(user_id, product_id) VALUES(?,?)";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setInt(2, productId);

            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateOrder(int id, int userId, int productId) {
        // TODO
    }

    @Override
    public void deleteOrder(int id) {
        String sql = "SELECT FROM orders WHERE id = ?";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {

            statement.setInt(1, id);

            if (statement.executeQuery() == null) {
                System.out.println("Order not found!");
                return;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "DELETE FROM orders WHERE id = ?";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showAllProducts() {
        String sql = "SELECT * FROM products";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showAllOrdersFromUser(int userId) {
        String sql = "SELECT * FROM orders WHERE user_id = ?";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setInt(1, userId);

            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int getUserIdByNameAndPassword(String name, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE name = ? AND password = ?";

        try (PreparedStatement statement = this.getDatabaseConnection().prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, password);

            ResultSet queryResult = statement.executeQuery();

            if (queryResult.next()) {
                return queryResult.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // not found
        return 0;
    }
}