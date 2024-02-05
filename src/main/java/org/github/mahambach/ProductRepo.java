package org.github.mahambach;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    //Properties
    private final List<Product> productList;

    //Constructors
    public ProductRepo(){
        this.productList =new ArrayList<>();
    }
    public ProductRepo(List<Product> productList) {
        this.productList = productList;
    }

    //Methods
    public void addProduct(Product product){
        this.productList.add(product);
    }

    public void addProduct(List<Product> products){
        this.productList.addAll(products);
    }

    public Product getProductByName(String productName){
        for(Product product : productList){
            if(product.productName().equals(productName)) return product;
        }
        return null;
    }

    public Product getProductByID(int productID){
        for(Product product : productList){
            if(product.productID() == productID) return product;
        }
        return null;
    }

    public List<Product> getAllProductsByPartialName(String productNameSegment){
        List<Product> returnList = new ArrayList<>();
        for(Product product : productList){
            if(product.productName().contains(productNameSegment)) returnList.add(product);
        }
        return returnList;
    }

    public List<Product> getAllProducts(){
        return this.productList;
    }

}
