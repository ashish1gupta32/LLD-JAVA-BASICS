package lld.OrderManagementSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProductCategory {
    int categoryId;
    String name;
    ProductCategory(int categoryId,String name){
        this.categoryId=categoryId;
        this.name=name;
    }
    List<Product> productList=new ArrayList<>();
    double price;
    void addProduct(Product product){
        productList.add(product);
    }

    void removeProduct(){
        if(!productList.isEmpty())productList.remove(productList.size()-1);
    }
}
