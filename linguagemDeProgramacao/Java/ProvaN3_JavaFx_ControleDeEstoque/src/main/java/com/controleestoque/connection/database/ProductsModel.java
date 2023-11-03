package com.controleestoque.connection.database;

import java.sql.Timestamp;

/**
 * This class is responsible for the product model that is gonna be used on the
 * controller to create,update,delete and read a product on the database
 */
public class ProductsModel {
    private int id;
    private String name;
    private double price;
    private int quantity;

    private Timestamp created_at;

    private Timestamp last_update_at;

    /**
     * This constructor is used to create a product by the user
     */
    public ProductsModel(String name, double price, int quantity) {
        // Checks the product data before creating it
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio");
        } else if (price < 0 || quantity < 0) {
            throw new IllegalArgumentException("Preço e quantidade não podem ser menores do que 0 (Zero)");
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.created_at = new Timestamp(System.currentTimeMillis());
        this.last_update_at = new Timestamp(System.currentTimeMillis());
    }

    /**
     * This constructor is used to load the product from the database
     */
    public ProductsModel(int id, String name, double price, int quantity, Timestamp createAt, Timestamp lastUpdateAt) {
        // Checks the product data before creating it
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        } else if (price < 0 || quantity < 0) {
            throw new IllegalArgumentException("Price or quantity cannot be less than 0");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.created_at = createAt;
        this.last_update_at = lastUpdateAt;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;

        // Updates the last time the product was updated
        this.last_update_at = new Timestamp(System.currentTimeMillis());
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be less than 0");
        }
        this.price = price;

        // Updates the last time the product was updated
        this.last_update_at = new Timestamp(System.currentTimeMillis());
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        }
        this.quantity = quantity;

        // Updates the last time the product was updated
        this.last_update_at = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getCreationDate() {
        return created_at;
    }

    public Timestamp getLastTimeUpdated() {
        return last_update_at;
    }
}
