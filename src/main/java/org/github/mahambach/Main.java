package org.github.mahambach;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add( new Product(1, "Laptop", new BigDecimal("999.99"), 50));
        productList.add( new Product(2, "Smartphone", new BigDecimal("599.95"), 100));
        productList.add( new Product(3, "Headphones", new BigDecimal("79.99"), 200));
        productList.add( new Product(4, "Coffee Maker", new BigDecimal("49.50"), 30));
        productList.add( new Product(5, "Fitness Tracker", new BigDecimal("129.99"), 80));
        productList.add( new Product(6, "External Hard Drive", new BigDecimal("89.95"), 40));
        productList.add( new Product(7, "Wireless Mouse", new BigDecimal("29.99"), 120));
        productList.add( new Product(8, "Desk Chair", new BigDecimal("149.75"), 15));
        productList.add( new Product(9, "LED TV", new BigDecimal("799.50"), 25));
        productList.add( new Product(10, "Gaming Console", new BigDecimal("349.99"), 60));

        Order order1 = new Order(1, "C1001", Arrays.asList(
                new Product(101, "Laptop", new BigDecimal("999.99"), 2),
                new Product(102, "Smartphone", new BigDecimal("599.95"), 3)
        ));

        Order order2 = new Order(2, "C1002", Arrays.asList(
                new Product(103, "Headphones", new BigDecimal("79.99"), 1),
                new Product(104, "Coffee Maker", new BigDecimal("49.50"), 2),
                new Product(105, "Fitness Tracker", new BigDecimal("129.99"), 1)
        ));

        Order order3 = new Order(3, "C1003", Arrays.asList(
                new Product(106, "External Hard Drive", new BigDecimal("89.95"), 1),
                new Product(107, "Wireless Mouse", new BigDecimal("29.99"), 4)
        ));

        Order order4 = new Order(4, "C1004", Arrays.asList(
                new Product(108, "Desk Chair", new BigDecimal("149.75"), 2),
                new Product(109, "LED TV", new BigDecimal("799.50"), 1),
                new Product(110, "Gaming Console", new BigDecimal("349.99"), 1)
        ));

        Order order5 = new Order(5, "C1005", Arrays.asList(
                new Product(111, "Printer", new BigDecimal("129.00"), 1),
                new Product(112, "Monitor", new BigDecimal("249.99"), 2),
                new Product(113, "Keyboard", new BigDecimal("49.99"), 3)
        ));

        Order order6 = new Order(6, "C1006", Arrays.asList(
                new Product(114, "Camera", new BigDecimal("399.95"), 1),
                new Product(115, "Router", new BigDecimal("79.50"), 2)
        ));

        Order order7 = new Order(7, "C1007", Arrays.asList(
                new Product(116, "External SSD", new BigDecimal("129.99"), 1),
                new Product(117, "Tablet", new BigDecimal("199.50"), 2),
                new Product(118, "Bluetooth Speaker", new BigDecimal("59.99"), 1)
        ));

        Order order8 = new Order(8, "C1008", Arrays.asList(
                new Product(119, "Desk Lamp", new BigDecimal("24.75"), 3),
                new Product(120, "USB Hub", new BigDecimal("19.95"), 2)
        ));

        Order order9 = new Order(9, "C1009", Arrays.asList(
                new Product(121, "Smartwatch", new BigDecimal("149.99"), 2),
                new Product(122, "Graphic Card", new BigDecimal("499.50"), 1)
        ));

        Order order10 = new Order(10, "C1010", Arrays.asList(
                new Product(123, "Printer Paper", new BigDecimal("9.99"), 5),
                new Product(124, "Mouse Pad", new BigDecimal("7.50"), 4)
        ));

        List<Order> orderListOne = new ArrayList<>();
        orderListOne.add(order1);
        orderListOne.add(order2);
        orderListOne.add(order3);
        orderListOne.add(order4);
        orderListOne.add(order5);



        OrderMapRepo orderMapRepoOne = new OrderMapRepo(orderListOne);

        OrderMapRepo orderMapRepoTwo = new OrderMapRepo();
        orderMapRepoTwo.addOrder(order6);
        orderMapRepoTwo.addOrder(order7);
        orderMapRepoTwo.addOrder(order8);
        orderMapRepoTwo.addOrder(order9);
        orderMapRepoTwo.addOrder(order10);

        OrderListRepo orderListRepoOne = new OrderListRepo(orderListOne);

        OrderListRepo orderListRepoTwo= new OrderListRepo();
        orderListRepoTwo.addOrder(order6);
        orderListRepoTwo.addOrder(order7);
        orderListRepoTwo.addOrder(order8);
        orderListRepoTwo.addOrder(order9);
        orderListRepoTwo.addOrder(order10);

        System.out.println("orderMapRepoOne: " + orderMapRepoOne);
        System.out.println("orderMapRepoTwo: " + orderMapRepoTwo);
        System.out.println("orderListRepoOne: " + orderListRepoOne);
        System.out.println("orderListRepoTwo: " + orderListRepoTwo);

        ShopService shopServiceList = new ShopService(new ProductRepo(productList), orderListRepoOne);
        ShopService shopServiceMap = new ShopService(new ProductRepo(productList), orderMapRepoOne);

        System.out.println();
        System.out.println(shopServiceList);
        System.out.println(shopServiceMap);

        shopServiceList.placeOrder(order6);
        shopServiceList.placeOrder(order6);

        System.out.println();
        System.out.println("shopServiceMap.numberOfOrders: "+orderMapRepoOne.getNumberOfOrders());
        shopServiceMap.placeOrder(order6);
        System.out.println("shopServiceMap.numberOfOrders: "+orderMapRepoOne.getNumberOfOrders());
        shopServiceMap.placeOrder(order6);
        System.out.println("shopServiceMap.numberOfOrders: "+orderMapRepoOne.getNumberOfOrders());


        System.out.println();
        System.out.println(shopServiceList.getAllOrdersOfCustomerID("C1006"));
        System.out.println(shopServiceMap.getAllOrdersOfCustomerID("C1006"));
    }



}