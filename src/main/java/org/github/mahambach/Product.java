package org.github.mahambach;

import java.math.BigDecimal;

public record Product(
        int productID,
        String productName,
        BigDecimal productPrice,
        Integer productStock
) {
}
