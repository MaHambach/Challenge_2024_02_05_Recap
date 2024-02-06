package org.github.mahambach;

import java.math.BigDecimal;

public record Product(
        int productID,
        String productName,
        BigDecimal productPrice
) {
    @Override
    public String toString() {
        return String.format("Product{ ID = %6d, productName = %19s, Price= %8s €}",productID, productName, productPrice);
    }
}
