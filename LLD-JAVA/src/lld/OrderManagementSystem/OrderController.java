package lld.OrderManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    List<Order> orderList=new ArrayList<>();
    void addOrder(Order order){
        orderList.add(order);
    }
}
