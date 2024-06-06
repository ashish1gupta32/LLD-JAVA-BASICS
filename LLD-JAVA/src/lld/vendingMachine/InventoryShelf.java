package lld.vendingMachine;

public class InventoryShelf {
    public Item item;
    public int code;
    public int count;

    public InventoryShelf(Item item, int code, int count) {
        this.item = item;
        this.code = code;
        this.count = count;
    }
}
