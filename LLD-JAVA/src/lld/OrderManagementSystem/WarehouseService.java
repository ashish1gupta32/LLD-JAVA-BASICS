package lld.OrderManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class WarehouseService {
    List<Warehouse> warehouseList=new ArrayList<>();
    WarehouseSelector warehouseSelector;
    void addWarehouse(Warehouse warehouse){
        warehouseList.add(warehouse);
    }
    void removeWarehouse(){
        warehouseList.remove(warehouseList.size()-1);
    }
    Warehouse selectWarehouse(){
        return warehouseSelector.selectWarehouse(warehouseList);
    }

    public void setWarehouseSelector(WarehouseSelector warehouseSelector) {
        this.warehouseSelector = warehouseSelector;
    }
}
