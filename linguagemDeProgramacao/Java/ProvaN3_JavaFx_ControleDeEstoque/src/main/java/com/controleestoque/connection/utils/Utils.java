package com.controleestoque.connection.utils;

import java.util.ArrayList;

import com.controleestoque.connection.database.ProductsModel;

public class Utils {
    public static ProductsModel findProduct(ArrayList<ProductsModel> listOfProducts, int id) {

        for (ProductsModel Product : listOfProducts) {
            if (Product.getId() == id) {
                return Product;
            }
        }
        return null;
    }
}
