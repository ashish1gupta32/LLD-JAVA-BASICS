package lld.vendingMachine;

import lld.vendingMachine.state.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    public Inventory inventory;
    public List<Coin> coins;
    public State state;

    List<Item> itemSelectedList;

    VendingMachine() {
        inventory = new Inventory();
        coins = new ArrayList<>();
        state = State.getIdleState();
        itemSelectedList = new ArrayList<>();
        initializeVendingMachine();
        displayInventory();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public List<Item> getItemSelectedList() {
        return itemSelectedList;
    }

    void initializeVendingMachine(){
        for (int i = 0; i < 9; i++) {
            Item item;
            if (i < 3) item = new Item(ItemType.COKE, 20);
            else if (i < 6) item = new Item(ItemType.PEPSI, 25);
            else item = new Item(ItemType.JUICE, 50);
            this.inventory.addInventoryShelf(new InventoryShelf(item, 101 + i, 2));
        }
    }

    void displayInventory(){
        for(InventoryShelf inventoryShelf:inventory.inventoryShelfList){
            System.out.println(STR."Item code: \{inventoryShelf.code}, type: \{inventoryShelf.item.itemType}, count: \{inventoryShelf.count}, price: \{inventoryShelf.item.getPrice()}");
        }
    }


}
