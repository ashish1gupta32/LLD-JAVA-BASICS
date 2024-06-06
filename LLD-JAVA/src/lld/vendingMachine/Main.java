package lld.vendingMachine;

import lld.vendingMachine.state.State;

public class Main {
    public static void main(String[] args) throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        State vendingState = vendingMachine.getState();
        vendingState.clickOnInsertButton(vendingMachine);

        vendingState = vendingMachine.getState();
        vendingState.insertCoin(vendingMachine, Coin.PENNY);
        vendingState.insertCoin(vendingMachine, Coin.NICKEL);
        vendingState.insertCoin(vendingMachine, Coin.DIME);
        vendingState.insertCoin(vendingMachine, Coin.QUARTER);
        vendingState.insertCoin(vendingMachine, Coin.QUARTER);
        vendingState.insertCoin(vendingMachine, Coin.QUARTER);
        vendingState.insertCoin(vendingMachine, Coin.QUARTER);
        vendingState.insertCoin(vendingMachine, Coin.QUARTER);
        vendingState.insertCoin(vendingMachine, Coin.DIME);
        vendingState.clickOnSelectProductButton(vendingMachine);

        vendingState = vendingMachine.getState();

        vendingState.selectTheProduct(vendingMachine, 101);
        vendingState.selectTheProduct(vendingMachine, 101);
        vendingState.selectTheProduct(vendingMachine, 101);
        vendingState.selectTheProduct(vendingMachine, 105);
        vendingState.selectTheProduct(vendingMachine, 105);
        vendingState.selectTheProduct(vendingMachine, 108);
        vendingState.clickOnDispenseProductButton(vendingMachine);

        vendingState = vendingMachine.getState();
        vendingState.dispenseTheProduct(vendingMachine);
        vendingMachine.displayInventory();


    }
}
