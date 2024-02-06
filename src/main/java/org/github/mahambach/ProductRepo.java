package org.github.mahambach;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepo {
    //Properties
    private final List<Product> productList;
    private final List<Integer> productQuantities;

    //Constructors
    public ProductRepo(){
        this.productList = new ArrayList<>();
        this.productQuantities = new ArrayList<>();
    }
    public ProductRepo(List<Product> productList, List<Integer> productQuantities) {
        this.productList = productList;
        this.productQuantities = productQuantities;
    }

    //Methods
    public void addProduct(Product product){
        addProduct(product,0);
    }
    public void addProduct(Product product, int quantity){
        this.productList.add(product);
        this.productQuantities.add(quantity);
    }

    public void addProduct(List<Product> products){
        for(Product product : products){
            addProduct(product);
        }
    }
    public void addProduct(List<Product> products, List<Integer> productQuantities){
        if(products.size() == productQuantities.size()){
            for(int i = 0; i < productQuantities.size(); i++){
                addProduct(products.get(i), productQuantities.get(i));
            }
        }
        else {
            System.out.printf("Error: Trying to add %d Products, but only provides %d quantities.%n", products.size(), productQuantities.size());
        }
    }

    public int getProductQuantityByName(String productName){
        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i).productName().equals(productName)) return productQuantities.get(i);
        }
        return 0;
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

    public List<Product> getProductList() {
        return productList;
    }

    public List<Integer> getProductQuantities() {
        return productQuantities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(productList, that.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productList);
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < this.productList.size(); i++){
            result += productList.get(i) + String.format(" Stock: %3d%n", this.productQuantities.get(i));
        }
        return result;
    }

    public void stockProductByID(int productID, int quantity) {
        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i).productID()==productID){
                productQuantities.set(i, productQuantities.get(i) + quantity);
                return;
            }
        }
        System.out.println("Error: Product ID not found.");
    }

    public int getProductQuantityByID(int productID) {
        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i).productID() == productID) return productQuantities.get(i);
        }
        return 0;
    }
}
