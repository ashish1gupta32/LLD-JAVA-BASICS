package lld.vendingMachine.state;

import lld.vendingMachine.Coin;
import lld.vendingMachine.VendingMachine;

import static lld.vendingMachine.StateType.SELECTIONSTATE;

public class HasMoneyState extends State{
    @Override
    public String getStateName() {
        return "HASMONEYSTATE";
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println(STR."adding coin : \{coin.name()}, value : \{coin.value}");
        vendingMachine.getCoins().add(coin);
    }
    @Override
    public void clickOnSelectProductButton(VendingMachine vendingMachine) {
      vendingMachine.setState(SELECTIONSTATE.getState());
    }
}
