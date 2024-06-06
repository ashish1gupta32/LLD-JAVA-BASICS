package lld.vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public List<InventoryShelf> inventoryShelfList=new ArrayList<>();
    public InventoryShelf getInventoryShelfByCode(int code){
        return inventoryShelfList.stream().filter(val->val.code==code).findFirst().orElseThrow(()->new RuntimeException("not found"));
    }
    public void addInventoryShelf(InventoryShelf inventoryShelf){
        inventoryShelfList.add(inventoryShelf);
    }

}
