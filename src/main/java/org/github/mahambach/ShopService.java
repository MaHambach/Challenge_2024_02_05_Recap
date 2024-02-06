package org.github.mahambach;

import javax.swing.plaf.IconUIResource;
import java.util.List;
import java.util.Objects;

public class ShopService {
    //Properties
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    //Constructors


    public ShopService() {
        this.productRepo = new ProductRepo();
        this.orderRepo = new OrderListRepo();
    }

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    //Methods
    public void placeOrder(Order newOrder){
        int numberOffOrders = this.orderRepo.getNumberOfOrders();
        for(Order order : this.orderRepo.getAllOrders()){
            if(order.equals(newOrder)) {
                System.out.println("Error: Order has already been placed.");
                return;
            }
        }
        this.orderRepo.addOrder(newOrder);
        if(this.orderRepo.getNumberOfOrders()!=numberOffOrders+1) System.out.println("Error: Order has not been placed.");
    }
    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public OrderRepo getOrderRepo() {
        return orderRepo;
    }
    public void addProduct(Product product){
        this.productRepo.addProduct(product);
    }
    public void addProduct(Product product, int quantity){
        this.productRepo.addProduct(product, quantity);
    }
    public List<Order> getAllOrders(){
        return this.orderRepo.getAllOrders();
    }

    public int getProductStockByID(int productID){
        return this.productRepo.getProductQuantityByID(productID);
    }

    public void stockProductByID(int productID, int quantity){
        this.productRepo.stockProductByID(productID, quantity);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopService that = (ShopService) o;
        return Objects.equals(productRepo, that.productRepo) && Objects.equals(orderRepo, that.orderRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepo, orderRepo);
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderListRepo=" + orderRepo +
                '}';
    }

    public Order getOrderByID(int orderID){
        return this.orderRepo.getOrderByID(orderID);
    }

    public List<Order> getAllOrdersOfCustomerID(String customerID){
        return this.orderRepo.getAllOrdersOfCustomerID(customerID);
    }
    public Product getProductByID(int id){
        return this.productRepo.getProductByID(id);
    }
}
