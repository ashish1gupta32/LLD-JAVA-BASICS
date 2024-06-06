package lld.vendingMachine;

public enum Coin {
    PENNY(1),
    NICKEL(2),
    DIME(10),
    QUARTER(25);

    public final int value;
    Coin(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
