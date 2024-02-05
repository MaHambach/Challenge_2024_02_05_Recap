package org.github.mahambach;

import java.util.*;

public class OrderMapRepo implements OrderRepo{
    private final Map<String, Order> orderMap;

    public OrderMapRepo() {
        this.orderMap = new HashMap<>();
    }

    public OrderMapRepo(List<Order> orderList) {
        this.orderMap = new HashMap<>();
        addOrders(orderList);
    }

    @Override
    public void addOrder(Order order) {
        addOrders(List.of(order));
    }

    @Override
    public void addOrders(List<Order> orderList) {
        for(Order order : orderList){
            this.orderMap.put(String.valueOf(order.orderID()), order);
        }
    }

    @Override
    public int getNumberOfOrders() {
        return this.orderMap.size();
    }

    @Override
    public Order getOrderByID(int orderID) {
        return this.orderMap.get(String.valueOf(orderID));
    }

    @Override
    public List<Order> getAllOrdersOfCustomerID(String customerID) {
        List<Order> resultList = new ArrayList<>();
        for(Order order : orderMap.values()){
            if(order.customerID() == customerID) resultList.add(order);
        }
        return resultList;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderMap.values());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMapRepo that = (OrderMapRepo) o;
        return Objects.equals(orderMap, that.orderMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderMap);
    }

    @Override
    public String toString() {
        return "OrderMapRepo{" +
                "orderMap=" + orderMap +
                '}';
    }
}
