package org.github.mahambach;

import java.util.List;

public record Order(
        int orderID,
        String customerID,
        List<Product> productList

) {

    @Override
    public String toString() {
        return String.format("Order{orderID=%6d, customerID=\'%6s\', productList= %s}%n",orderID, customerID, productList);
    }
}
