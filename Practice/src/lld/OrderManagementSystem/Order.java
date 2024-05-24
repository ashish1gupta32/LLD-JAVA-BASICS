package lld.OrderManagementSystem;

import java.util.Map;

public class Order {
    int id;
    String name;
    Map<Integer,Integer> categoryCnt;
    Warehouse warehouse;
    Invoice invoice;
    Payment payment;
    User user;
    Order(int id,String name){
        this.id=id;
        this.name=name;
    }
    public void setCategoryCnt(Map<Integer, Integer> categoryCnt) {
        this.categoryCnt = categoryCnt;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public boolean checkout(){
        return true;
    }
}
