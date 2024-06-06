package lld.vendingMachine.state;

import lld.vendingMachine.VendingMachine;

import static lld.vendingMachine.StateType.*;

public class IdleState extends State{
    @Override
    public String getStateName() {
        return "IDLE";
    }
    @Override
    public void clickOnInsertButton(VendingMachine vendingMachine) throws Exception {
        System.out.println("Moving to HasMoney state");
        vendingMachine.setState(HASMONEYSTATE.getState());
    }
}
