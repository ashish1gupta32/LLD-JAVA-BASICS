package lld.OrderManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;
    Cart cart;
    List<Order> orderList=new ArrayList<>();
    User(int id,String name,Cart cart){
        this.id=id;
        this.name=name;
        this.cart=cart;
    }
    void addOrder(Order order){
        orderList.add(order);
    }
}
