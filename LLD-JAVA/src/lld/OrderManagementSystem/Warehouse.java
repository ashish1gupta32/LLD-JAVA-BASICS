package lld.OrderManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<Inventory> inventoryList=new ArrayList<>();
    Address address;
    void addInventory(Inventory inventory){
        inventoryList.add(inventory);
    }
    void removeInventory(){
        inventoryList.remove(inventoryList.size()-1);
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
