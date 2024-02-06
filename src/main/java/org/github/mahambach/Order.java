package org.github.mahambach;

import java.math.BigDecimal;
import java.util.List;

public record Order(
        int orderID,
        String customerID,
        BigDecimal price,
        List<Product> productList,
        List<Integer> productQuantities
) {
    public Order(int orderID, String customerID, BigDecimal price, List<Product> productList, List<Integer> productQuantities) {
        this.orderID = orderID;
        this.customerID=customerID;
        this.price=price;
        this.productList=productList;
        this.productQuantities = productQuantities;

        BigDecimal priceTest = BigDecimal.ZERO;
        for(Product product: productList){
            priceTest = priceTest.add(product.productPrice());
        }
        if(!(this.price.equals(priceTest))) System.out.printf("Error: Price in Order %d should be %s €, but is %s €.%n", this.orderID, priceTest, this.price);
        if(productList.size() != productQuantities.size()) System.out.printf("Error: Ordering %d different products, but only %d quantities given.%n", productList.size(), productQuantities.size());
    }

    @Override
    public String toString() {
        return String.format("Order{orderID=%6d, customerID=\'%6s\', Price= %8s€, productList= %s}%n",orderID, customerID, getOrderPrice().toString(),productList);
    }

    public BigDecimal getOrderPrice(){

        return this.price;
    }
}
