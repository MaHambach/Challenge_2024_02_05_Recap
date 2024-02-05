package org.github.mahambach;

import java.util.List;

public record Order(
        int orderID,
        String customerID,
        List<Product> productList

) {
}
