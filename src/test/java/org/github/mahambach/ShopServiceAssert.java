package org.github.mahambach;

import org.assertj.core.api.AbstractAssert;

public class ShopServiceAssert extends AbstractAssert<ShopServiceAssert, ShopService> {
    public static ShopServiceAssert assertThat(ShopService shopService){
        return new ShopServiceAssert(shopService);
    }
    protected ShopServiceAssert(ShopService shopService) {
        super(shopService, ShopServiceAssert.class);
    }

    public ShopServiceAssert hasNumberOfOrders(int expectedNumber){
        if(actual.getAllOrders().size() != expectedNumber){
            failWithMessage("Expected number of orders is " + expectedNumber + ", but was "+actual.getAllOrders().size()+".");
        }

        return this;
    }

    public ShopServiceAssert hasNumberOfProducts(int expectedNumber){
        if(actual.getProductRepo().getProductList().size() != expectedNumber){
            failWithMessage("Expected number of products is " + expectedNumber + ", but was "+actual.getProductRepo().getProductList().size()+".");
        }

        return this;
    }

}
