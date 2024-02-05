package org.github.mahambach;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo {
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
    public void addOrder(Order order){
        this.orderList.add(order);
    }

    public void addOrder(List<Order> orders){
        this.orderList.addAll(orders);
    }


    public Order getOrderByID(int orderID){
        for(Order order : orderList){
            if(order.orderID() == orderID) return order;
        }
        return null;
    }

    public List<Order> getAllOrdersOfClientID(String customerID){
        List<Order> returnList = new ArrayList<>();
        for(Order order : orderList){
            if(order.customerID().equals(customerID)) returnList.add(order);
        }
        return returnList;
    }

    public List<Order> getAllOrders(){
        return this.orderList;
    }

}
