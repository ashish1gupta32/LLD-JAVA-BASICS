package lld.OrderManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<ProductCategory>productCategories=new ArrayList<>();
    void addProductCategory(ProductCategory productCategory){
        productCategories.add(productCategory);
    }
    void removeProductCategory(){
        productCategories.remove(productCategories.size()-1);
    }
}
