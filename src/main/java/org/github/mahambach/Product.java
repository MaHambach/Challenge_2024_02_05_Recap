package org.github.mahambach;

import java.math.BigDecimal;
import java.util.Objects;

public record Product(
        int productID,
        String productName,
        BigDecimal productPrice
) {
    @Override
    public String toString() {
        return String.format("Product{ ID = %6d, productName = %19s, Price= %8s €}",productID, productName, productPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productID == product.productID && Objects.equals(productName, product.productName) && Objects.equals(productPrice, product.productPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, productName, productPrice);
    }
}
