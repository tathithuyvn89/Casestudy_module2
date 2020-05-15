package controller;

import model.Category;

public interface ProductAct {

    void showData(Category category);
    void addProduct();
    void editProduct();
    void sortProductByPriceDown(Category category);
    void deleteProductByID();
    void searchProductByName();
    void checkProductIsEmpty();
}
