package org.github.mahambach;

import java.util.List;

public interface OrderRepo {
    //Properties

    //Methods
    void addOrder(Order order);

    void addOrders(List<Order> orders);

    int getNumberOfOrders();
    Order getOrderByID(int orderID);

    List<Order> getAllOrdersOfCustomerID(String customerID);

    List<Order> getAllOrders();
}
