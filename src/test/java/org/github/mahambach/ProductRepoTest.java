package org.github.mahambach;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    void addProduct_whenAddAProduct_thenSizeOfProductListAndProductQuantitiesPlusOne() {
        ProductRepo productRepo = new ProductRepo();
        Product product = new Product(1, "Laptop", new BigDecimal("999.99"));
        int numberOfProducts = productRepo.getProductList().size();

        productRepo.addProduct(product);

        assertEquals(numberOfProducts+1, productRepo.getProductList().size());
        assertEquals(numberOfProducts+1, productRepo.getProductQuantities().size());
    }

    @Test
    void addProduct_whenAddAProductWithQuantity_thenSizeOfProductListPlusOneAndProductQuantetiesLastIsQuantity() {
        ProductRepo productRepo = new ProductRepo();
        Product product = new Product(1, "Laptop", new BigDecimal("999.99"));
        int quantity = 100;
        int numberOfProducts = productRepo.getProductList().size();

        productRepo.addProduct(product, quantity);

        assertEquals(numberOfProducts+1, productRepo.getProductList().size());
        assertEquals(quantity, productRepo.getProductQuantities().getLast());
    }

    @Test
    void addProduct_whenAddListOfTwoProducts_thenSizeOfProductListAndProductQuantitiesPlusTwo() {
        ProductRepo productRepo = new ProductRepo();
        List<Product> productList = new ArrayList<>();
        productList.add( new Product(1, "Laptop", new BigDecimal("999.99")));
        productList.add( new Product(2, "Smartphone", new BigDecimal("599.95")));
        int numberOfProducts = productRepo.getProductList().size();

        productRepo.addProduct(productList);

        assertEquals(numberOfProducts+2, productRepo.getProductList().size());
        assertEquals(numberOfProducts+2, productRepo.getProductQuantities().size());
    }

    @Test
    void addProduct_whenAddListOfTwoProducts_thenSizeOfProductListPlusOneAndProductQuantetiesLastTwoAreQuantity() {
        ProductRepo productRepo = new ProductRepo();
        List<Product> productList = new ArrayList<>();
        productList.add( new Product(1, "Laptop", new BigDecimal("999.99")));
        productList.add( new Product(2, "Smartphone", new BigDecimal("599.95")));
        List<Integer> quantities = new ArrayList<>();
        quantities.add(10);
        quantities.add(100);
        int numberOfProducts = productRepo.getProductList().size();

        productRepo.addProduct(productList, quantities);

        assertEquals(numberOfProducts+2, productRepo.getProductList().size());
        assertEquals(quantities.get(0), productRepo.getProductQuantities().get(numberOfProducts));
        assertEquals(quantities.get(1), productRepo.getProductQuantities().get(numberOfProducts+1));
    }

    @Test
    void getProductQuantityByName() {
    }

    @Test
    void getProductByName() {
    }

    @Test
    void getProductByID() {
    }

    @Test
    void getAllProductsByPartialName() {
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void getProductList() {
    }

    @Test
    void getProductQuantities() {
    }
}