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
    void getProductQuantityByName_whenLaptop_then10() {
        ProductRepo productRepo = new ProductRepo();
        List<Product> productList = new ArrayList<>();
        productList.add( new Product(1, "Laptop", new BigDecimal("999.99")));
        productList.add( new Product(2, "Smartphone", new BigDecimal("599.95")));
        List<Integer> quantities = new ArrayList<>();
        quantities.add(10);
        quantities.add(100);
        int numberOfProducts = productRepo.getProductList().size();

        productRepo.addProduct(productList, quantities);

        assertEquals(10, productRepo.getProductQuantityByName("Laptop"));
    }
    @Test
    void getProductQuantityByName_whenPotato_then0() {
        ProductRepo productRepo = new ProductRepo();
        List<Product> productList = new ArrayList<>();
        productList.add( new Product(1, "Laptop", new BigDecimal("999.99")));
        productList.add( new Product(2, "Smartphone", new BigDecimal("599.95")));
        List<Integer> quantities = new ArrayList<>();
        quantities.add(10);
        quantities.add(100);

        productRepo.addProduct(productList, quantities);

        assertEquals(0, productRepo.getProductQuantityByName("Potato"));
    }

    @Test
    void getProductByName_whenLaptop_thenProduct1() {
        ProductRepo productRepo = new ProductRepo();
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product(1, "Laptop", new BigDecimal("999.99"));
        Product product2 = new Product(2, "Smartphone", new BigDecimal("599.95"));
        productList.add(product1);
        productList.add(product2);
        List<Integer> quantities = new ArrayList<>();
        quantities.add(10);
        quantities.add(100);

        productRepo.addProduct(productList, quantities);

        assertEquals(product1, productRepo.getProductByName("Laptop"));
    }

    @Test
    void getProductByID_when2_thenProduct2() {
        ProductRepo productRepo = new ProductRepo();
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product(1, "Laptop", new BigDecimal("999.99"));
        Product product2 = new Product(2, "Smartphone", new BigDecimal("599.95"));
        productList.add(product1);
        productList.add(product2);
        List<Integer> quantities = new ArrayList<>();
        quantities.add(10);
        quantities.add(100);

        productRepo.addProduct(productList, quantities);

        assertEquals(product2, productRepo.getProductByID(2));
    }

    @Test
    void getAllProductsByPartialName_whena_thenLaptopAndSmartphone() {
        ProductRepo productRepo = new ProductRepo();
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product(1, "Laptop", new BigDecimal("999.99"));
        Product product2 = new Product(2, "Smartphone", new BigDecimal("599.95"));
        productList.add(product1);
        productList.add(product2);
        List<Integer> quantities = new ArrayList<>();
        quantities.add(10);
        quantities.add(100);

        productRepo.addProduct(productList, quantities);

        assertEquals(productList, productRepo.getAllProductsByPartialName("a"));
    }


    @Test
    void getAllProductsByPartialName_whenx_thenEmpty() {
        ProductRepo productRepo = new ProductRepo();
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product(1, "Laptop", new BigDecimal("999.99"));
        Product product2 = new Product(2, "Smartphone", new BigDecimal("599.95"));
        productList.add(product1);
        productList.add(product2);
        List<Integer> quantities = new ArrayList<>();
        quantities.add(10);
        quantities.add(100);

        productRepo.addProduct(productList, quantities);

        assertEquals(new ArrayList<>(), productRepo.getAllProductsByPartialName("x"));
    }

    @Test
    void getAllProducts_whenLaptopAndSmartphone_thenLaptopAndSmartphone() {
        ProductRepo productRepo = new ProductRepo();
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product(1, "Laptop", new BigDecimal("999.99"));
        Product product2 = new Product(2, "Smartphone", new BigDecimal("599.95"));
        productList.add(product1);
        productList.add(product2);
        List<Integer> quantities = new ArrayList<>();
        quantities.add(10);
        quantities.add(100);

        productRepo.addProduct(productList, quantities);

        assertEquals(productList, productRepo.getAllProducts());
    }


    @Test
    void getAllProducts_whenEmpty_thenEmpty() {
        ProductRepo productRepo = new ProductRepo();


        assertTrue(productRepo.getAllProducts().isEmpty());
    }
}