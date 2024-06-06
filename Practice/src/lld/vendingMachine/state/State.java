package lld.vendingMachine.state;

import lld.vendingMachine.Coin;
import lld.vendingMachine.VendingMachine;

import static lld.vendingMachine.StateType.IDLESTATE;

public abstract class State {

    abstract public String getStateName();

    public void clickOnInsertButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception(STR."Click on insert button is not allowed in\{getStateName()} state");
    }
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception(STR."Click on insert coin is not allowed in\{getStateName()} state");
    }
    public void clickOnSelectProductButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception(STR."Click on select product button is not allowed in\{getStateName()} state");
    }
    public void selectTheProduct(VendingMachine vendingMachine,int productCode) throws Exception {
        throw new Exception(STR."Product selection is not allowed in\{getStateName()} state");
    }
    public void clickOnDispenseProductButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception(STR."Click on dispense product  is not allowed in\{getStateName()} state");
    }
    public void dispenseTheProduct(VendingMachine vendingMachine) throws Exception {
        throw new Exception(STR."Product dispense is not allowed in\{getStateName()} state");
    }
    public void cancelOrCompleteTransaction(VendingMachine vendingMachine) {
        System.out.println("canceling/completing the transaction moving to idle state");
        vendingMachine.setState(getIdleState());
        vendingMachine.getItemSelectedList().clear();
    }
    public static State getIdleState(){
        return IDLESTATE.getState();
    }
     void refund(int paidAmount, int totalCost) {
        System.out.println(STR."total cost:\{totalCost}");
        System.out.println(STR."paid Amount:\{paidAmount}");
        System.out.println(STR."amount refunded:\{paidAmount - totalCost}");
    }
     void refund(int paidAmount) {
        System.out.println(STR."paid Amount:\{paidAmount}");
        System.out.println(STR."amount refunded:\{paidAmount}");
    }

}
