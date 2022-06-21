package ua.kosheleva.hw26.service;

import ua.kosheleva.hw26.dao.ProductDao;

public class ProductService {
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void runProductService() {
        System.out.println("=".repeat(220));
        System.out.println("printAllProducts");
        printAllProducts();
        System.out.println("=".repeat(220));
        System.out.println("changeProductPrice");
        changeProductPrice("mushrooms", 39.8f);
        System.out.println("=".repeat(220));
        System.out.println("printAllProducts");
        printAllProducts();
        System.out.println("=".repeat(220));
    }

    private void changeProductPrice(String productName, Float price) {
        productDao.updatePrice(productName, price);
    }

    private void printAllProducts() {
        productDao.findAll().forEach(System.out::println);
    }
}
