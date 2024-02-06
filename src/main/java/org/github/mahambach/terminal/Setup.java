package org.github.mahambach.terminal;

import org.github.mahambach.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Setup {
    public static ProductRepo setupProductMapRepo(){
        List<Product> productList = new ArrayList<>();
        productList.add( new Product(1, "Laptop", new BigDecimal("999.99")));
        productList.add( new Product(2, "Smartphone", new BigDecimal("599.95")));
        productList.add( new Product(3, "Headphones", new BigDecimal("79.99")));
        productList.add( new Product(4, "Coffee Maker", new BigDecimal("49.50")));
        productList.add( new Product(5, "Fitness Tracker", new BigDecimal("129.99")));
        productList.add( new Product(6, "External Hard Drive", new BigDecimal("89.95")));
        productList.add( new Product(7, "Wireless Mouse", new BigDecimal("29.99")));
        productList.add( new Product(8, "Desk Chair", new BigDecimal("149.75")));
        productList.add( new Product(9, "LED TV", new BigDecimal("799.50")));
        productList.add( new Product(10, "Gaming Console", new BigDecimal("349.99")));

        List<Integer> productQuantities = new ArrayList<>();
        productQuantities.add(50);
        productQuantities.add(100);
        productQuantities.add(200);
        productQuantities.add(30);
        productQuantities.add(80);
        productQuantities.add(40);
        productQuantities.add(120);
        productQuantities.add(15);
        productQuantities.add(25);
        productQuantities.add(60);
        for(Product product: productList){
            System.out.println(product.productName().length());
        }
        return new ProductRepo(productList, productQuantities);
    }

    public static OrderMapRepo setupOrderList() {
        Order order1 = new Order(1, "C1001", new BigDecimal("1599.94"),Arrays.asList(
                new Product(101, "Laptop", new BigDecimal("999.99")),
                new Product(102, "Smartphone", new BigDecimal("599.95"))
        ), List.of(2,3) );

        Order order2 = new Order(2, "C1002", new BigDecimal("259.48"), Arrays.asList(
                new Product(103, "Headphones", new BigDecimal("79.99")),
                new Product(104, "Coffee Maker", new BigDecimal("49.50")),
                new Product(105, "Fitness Tracker", new BigDecimal("129.99"))
        ), List.of(1,2,1) );

        Order order3 = new Order(3, "C1003", new BigDecimal("119.94"), Arrays.asList(
                new Product(106, "External Hard Drive", new BigDecimal("89.95")),
                new Product(107, "Wireless Mouse", new BigDecimal("29.99"))
        ), List.of(1,4) );

        Order order4 = new Order(4, "C1004", new BigDecimal("1299.24"), Arrays.asList(
                new Product(108, "Desk Chair", new BigDecimal("149.75")),
                new Product(109, "LED TV", new BigDecimal("799.50")),
                new Product(110, "Gaming Console", new BigDecimal("349.99"))
        ), List.of(2,1,1) );

        Order order5 = new Order(5, "C1005", new BigDecimal("428.98"), Arrays.asList(
                new Product(111, "Printer", new BigDecimal("129.00")),
                new Product(112, "Monitor", new BigDecimal("249.99")),
                new Product(113, "Keyboard", new BigDecimal("49.99"))
        ), List.of(1,2,3) );

        Order order6 = new Order(6, "C1006", new BigDecimal("479.45"), Arrays.asList(
                new Product(114, "Camera", new BigDecimal("399.95")),
                new Product(115, "Router", new BigDecimal("79.50"))
        ), List.of(1,2) );

        Order order7 = new Order(7, "C1007", new BigDecimal("389.48"), Arrays.asList(
                new Product(116, "External SSD", new BigDecimal("129.99")),
                new Product(117, "Tablet", new BigDecimal("199.50")),
                new Product(118, "Bluetooth Speaker", new BigDecimal("59.99"))
        ), List.of(1,2,1) );

        Order order8 = new Order(8, "C1008", new BigDecimal("44.70"), Arrays.asList(
                new Product(119, "Desk Lamp", new BigDecimal("24.75")),
                new Product(120, "USB Hub", new BigDecimal("19.95"))
        ), List.of(3,2) );

        Order order9 = new Order(9, "C1009", new BigDecimal("649.49"), Arrays.asList(
                new Product(121, "Smartwatch", new BigDecimal("149.99")),
                new Product(122, "Graphic Card", new BigDecimal("499.50"))
        ), List.of(2,1) );

        Order order10 = new Order(10, "C1010", new BigDecimal("17.49"), Arrays.asList(
                new Product(123, "Printer Paper", new BigDecimal("9.99")),
                new Product(124, "Mouse Pad", new BigDecimal("7.50"))
        ), List.of(4,5) );

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);
        orderList.add(order6);
        orderList.add(order7);
        orderList.add(order8);
        orderList.add(order9);
        orderList.add(order10);


        return new OrderMapRepo();
    }

    public static ShopService setupShopService(){
        ShopService shopService = new ShopService();

        Product product0 = new Product(1, "Laptop", new BigDecimal("999.99"));
        Product product1 = new Product(2, "Smartphone", new BigDecimal("599.95"));
        Product product2 = new Product(3, "Headphones", new BigDecimal("79.99"));
        Product product3 = new Product(4, "Coffee Maker", new BigDecimal("49.50"));
        Product product4 = new Product(5, "Fitness Tracker", new BigDecimal("129.99"));
        Product product5 = new Product(6, "External Hard Drive", new BigDecimal("89.95"));
        Product product6 = new Product(7, "Wireless Mouse", new BigDecimal("29.99"));
        Product product7 = new Product(8, "Desk Chair", new BigDecimal("149.75"));
        Product product8 = new Product(9, "LED TV", new BigDecimal("799.50"));
        Product product9 = new Product(10, "Gaming Console", new BigDecimal("349.99"));
        shopService.addProduct(product0, 50);
        shopService.addProduct(product1,50);
        shopService.addProduct(product2,100);
        shopService.addProduct(product3,200);
        shopService.addProduct(product4,30);
        shopService.addProduct(product5,80);
        shopService.addProduct(product6,40);
        shopService.addProduct(product7,120);
        shopService.addProduct(product8,15);
        shopService.addProduct(product9,25);
        shopService.addProduct(product3,60);

        Order order1 = new Order(1, "C1001", new BigDecimal("1599.94"),Arrays.asList(
                new Product(101, "Laptop", new BigDecimal("999.99")),
                new Product(102, "Smartphone", new BigDecimal("599.95"))
        ), List.of(2,3) );

        Order order2 = new Order(2, "C1002", new BigDecimal("259.48"), Arrays.asList(
                new Product(103, "Headphones", new BigDecimal("79.99")),
                new Product(104, "Coffee Maker", new BigDecimal("49.50")),
                new Product(105, "Fitness Tracker", new BigDecimal("129.99"))
        ), List.of(1,2,1) );

        Order order3 = new Order(3, "C1003", new BigDecimal("119.94"), Arrays.asList(
                new Product(106, "External Hard Drive", new BigDecimal("89.95")),
                new Product(107, "Wireless Mouse", new BigDecimal("29.99"))
        ), List.of(1,4) );

        Order order4 = new Order(4, "C1004", new BigDecimal("1299.24"), Arrays.asList(
                new Product(108, "Desk Chair", new BigDecimal("149.75")),
                new Product(109, "LED TV", new BigDecimal("799.50")),
                new Product(110, "Gaming Console", new BigDecimal("349.99"))
        ), List.of(2,1,1) );

        Order order5 = new Order(5, "C1005", new BigDecimal("428.98"), Arrays.asList(
                new Product(111, "Printer", new BigDecimal("129.00")),
                new Product(112, "Monitor", new BigDecimal("249.99")),
                new Product(113, "Keyboard", new BigDecimal("49.99"))
        ), List.of(1,2,3) );

        Order order6 = new Order(6, "C1006", new BigDecimal("479.45"), Arrays.asList(
                new Product(114, "Camera", new BigDecimal("399.95")),
                new Product(115, "Router", new BigDecimal("79.50"))
        ), List.of(1,2) );

        Order order7 = new Order(7, "C1007", new BigDecimal("389.48"), Arrays.asList(
                new Product(116, "External SSD", new BigDecimal("129.99")),
                new Product(117, "Tablet", new BigDecimal("199.50")),
                new Product(118, "Bluetooth Speaker", new BigDecimal("59.99"))
        ), List.of(1,2,1) );

        Order order8 = new Order(8, "C1008", new BigDecimal("44.70"), Arrays.asList(
                new Product(119, "Desk Lamp", new BigDecimal("24.75")),
                new Product(120, "USB Hub", new BigDecimal("19.95"))
        ), List.of(3,2) );

        Order order9 = new Order(9, "C1009", new BigDecimal("649.49"), Arrays.asList(
                new Product(121, "Smartwatch", new BigDecimal("149.99")),
                new Product(122, "Graphic Card", new BigDecimal("499.50"))
        ), List.of(2,1) );

        Order order10 = new Order(10, "C1010", new BigDecimal("17.49"), Arrays.asList(
                new Product(123, "Printer Paper", new BigDecimal("9.99")),
                new Product(124, "Mouse Pad", new BigDecimal("7.50"))
        ), List.of(4,5) );

        shopService.placeOrder(order1);
        shopService.placeOrder(order2);
        shopService.placeOrder(order3);
        shopService.placeOrder(order4);
        shopService.placeOrder(order5);
        shopService.placeOrder(order6);
        shopService.placeOrder(order7);
        shopService.placeOrder(order8);
        shopService.placeOrder(order9);
        shopService.placeOrder(order10);

        return shopService;
    }
}
