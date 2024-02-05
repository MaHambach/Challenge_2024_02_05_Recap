package org.github.mahambach;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderListRepo implements OrderRepo {
    //Properties
    private final List<Order> orderList;

    //Constructors
    public OrderListRepo() {
        this.orderList = new ArrayList<>();
    }
    public OrderListRepo(List<Order> orderList) {
        this.orderList = orderList;
    }

    //Methods
    @Override
    public void addOrder(Order order){
        this.orderList.add(order);
    }

    @Override

    public void addOrders(List<Order> orders){
        this.orderList.addAll(orders);
    }

    @Override
    public int getNumberOfOrders() {
        return this.orderList.size();
    }

    @Override
    public Order getOrderByID(int orderID){
        for(Order order : orderList){
            if(order.orderID() == orderID) return order;
        }
        return null;
    }

    @Override
    public List<Order> getAllOrdersOfCustomerID(String customerID){
        List<Order> returnList = new ArrayList<>();
        for(Order order : orderList){
            if(order.customerID().equals(customerID)) returnList.add(order);
        }
        return returnList;
    }

    @Override
    public List<Order> getAllOrders(){
        return this.orderList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderListRepo that = (OrderListRepo) o;
        return Objects.equals(orderList, that.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderList);
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orderList=" + orderList +
                '}';
    }
}
