package org.github.mahambach;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.github.mahambach.ShopServiceAssert.*;
import static org.github.mahambach.terminal.Setup.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopServiceTestCustomMatcher {

    @Test
    void placeOrder_whenOrder1_thenNumberOfOrdersPlusOne() {
        ShopService shopService = new ShopService();
        Product product1 = new Product(102, "Smartphone", new BigDecimal("599.95"));
        Order order1 = new Order(1, "C101", product1.productPrice(), List.of(product1), List.of(2));
        int oldNumberOfOrders = shopService.getAllOrders().size();

        shopService.placeOrder(order1);

        assertThat(shopService).hasNumberOfOrders(oldNumberOfOrders+1);
    }

    @Test
    void addProduct_whenProduct1_thenNumberOfProductsPlusOne() {
        ShopService shopService = new ShopService();
        Product product1 = new Product(102, "Smartphone", new BigDecimal("599.95"));
        int oldNumberOfProducts = shopService.getProductRepo().getProductList().size();

        shopService.addProduct(product1);

        assertThat(shopService).hasNumberOfProducts(oldNumberOfProducts+1);
    }

    @Test
    void AddProduct_whenProduct1Times10_thenGetProductStockByID102is10() {
        ShopService shopService = new ShopService();
        Product product1 = new Product(102, "Smartphone", new BigDecimal("599.95"));
        int numberOfProducts = shopService.getProductRepo().getProductList().size();

        shopService.addProduct(product1, 10);

        assertEquals(10, shopService.getProductStockByID(102));
    }

    @Test
    void getAllOrders_whenSetupShopService_thenSetupOrderListGetAllOrders() {
        ShopService shopService = setupShopService();

        assertEquals(setupOrderList().getAllOrders(), shopService.getAllOrders());
    }

    @Test
    void stockProductByID_whenProduct1plus10_then20() {
        ShopService shopService = new ShopService();
        Product product1 = new Product(102, "Smartphone", new BigDecimal("599.95"));
        int numberOfProducts = shopService.getProductRepo().getProductList().size();

        shopService.addProduct(product1, 10);
        shopService.stockProductByID(102,10);

        assertEquals(20, shopService.getProductStockByID(102));
    }



    @Test
    void getAllOrdersOfCustomerID_whenSetupShopServiceAndC1010_thenOrder10() {
        ShopService shopService = setupShopService();

        assertEquals(List.of(shopService.getOrderByID(10)), shopService.getAllOrdersOfCustomerID("C1010"));
    }

    @Test
    void getProductByID_whenSetupShopServiceAnd9_thenProductLED_TV() {
        ShopService shopService = setupShopService();
        Product product = new Product(9, "LED TV", new BigDecimal("799.50"));

        assertEquals(product, shopService.getProductByID(9));
    }
}