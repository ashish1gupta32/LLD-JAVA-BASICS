package lld.vendingMachine.state;

import lld.vendingMachine.InventoryShelf;
import lld.vendingMachine.VendingMachine;

import static lld.vendingMachine.StateType.DISPENSESTATE;

public class SelectionState extends State{
    @Override
    public String getStateName() {
        return "SELECTION";
    }

    @Override
    public void selectTheProduct(VendingMachine vendingMachine, int productCode) {
        InventoryShelf inventoryShelf = vendingMachine.inventory.getInventoryShelfByCode(productCode);
        System.out.println(STR."\{inventoryShelf.item.itemType} has been selelected");

        if (inventoryShelf.count > vendingMachine.getItemSelectedList().stream().filter((val -> inventoryShelf.item.equals(val))).count()) {
            vendingMachine.getItemSelectedList().add(inventoryShelf.item);
        } else {
            System.out.println(STR."no more \{productCode} product is available in itentory shelf");
            System.out.println("select other product");
        }

    }

    @Override
    public void clickOnDispenseProductButton(VendingMachine vendingMachine){
        vendingMachine.setState(DISPENSESTATE.getState());
    }
}
