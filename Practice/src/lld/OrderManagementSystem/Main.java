package lld.OrderManagementSystem;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Product product1=new Product(1,"abc");
        Product product2=new Product(2,"bcd");

        ProductCategory productCategory1=new ProductCategory(1,"A1");
        ProductCategory productCategory2=new ProductCategory(2,"B1");

        productCategory1.addProduct(product1);
        productCategory2.addProduct(product2);

        Inventory inventory=new Inventory();
        inventory.addProductCategory(productCategory1);
        inventory.addProductCategory(productCategory2);

        Address address=new Address(821311,"Maharastra");
        Warehouse warehouse=new Warehouse();
        warehouse.addInventory(inventory);
        warehouse.setAddress(address);


        WarehouseSelector warehouseSelector=new WarehouseSelector();
        WarehouseService warehouseService=new WarehouseService();
        warehouseService.setWarehouseSelector(warehouseSelector);
        warehouseService.addWarehouse(warehouse);

        Cart cart=new Cart();
        cart.addItem(productCategory1.categoryId);
        cart.addItem(productCategory1.categoryId);
        cart.addItem(productCategory2.categoryId);

        User user=new User(1,"user1",cart);
        OrderController orderController=new OrderController();
        Warehouse user1Warehouse=warehouseService.selectWarehouse();

        Invoice invoice=new Invoice();
        Payment payment=new Payment();
        Order order=new Order(1,"order1");
        order.setCategoryCnt(cart.categoryMap);
        order.setWarehouse(user1Warehouse);
        order.setInvoice(invoice);
        order.setPayment(payment);
        order.setUser(user);

        UserController userController=new UserController();
        userController.addUser(user);

        user.addOrder(order);
        orderController.addOrder(order);
        Set<Integer> st=new TreeSet<>();
        cart.viewCart();

    }
}
