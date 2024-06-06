package lld.vendingMachine.state;

import lld.vendingMachine.Coin;
import lld.vendingMachine.InventoryShelf;
import lld.vendingMachine.Item;
import lld.vendingMachine.VendingMachine;

import java.util.Map;
import java.util.stream.Collectors;

public class DispenseState extends State {
    @Override
    public String getStateName() {
        return "DISPENSE";
    }

    @Override
    public void dispenseTheProduct(VendingMachine vendingMachine) {
        int totalCost = vendingMachine.getItemSelectedList().stream().mapToInt(Item::getPrice).sum();
        int paidAmount = vendingMachine.getCoins().stream().mapToInt(Coin::getValue).sum();
        if (paidAmount >= totalCost) {
            Map<Item, Long> itemCountMapping = vendingMachine.getItemSelectedList().stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));

            vendingMachine.inventory.inventoryShelfList.forEach((inventoryShelf) -> {
                if (itemCountMapping.containsKey(inventoryShelf.item)) {
                    inventoryShelf.count -= itemCountMapping.get(inventoryShelf.item);
                }
            });

            refund(paidAmount, totalCost);
            cancelOrCompleteTransaction(vendingMachine);
        } else {
            System.out.println(STR."paid amount: \{paidAmount}");
            System.out.println(STR."total cost: \{totalCost}");
            System.out.println("paid amount is less than total amount");
            refund(totalCost);
            cancelOrCompleteTransaction(vendingMachine);
        }
    }


}
