package lld.CarRentalSystem.payment;

import lld.CarRentalSystem.Bill;

public class Payment {
    Bill bill;

    public void PayBill(Bill bill) {
        bill.setPaid(true);
        System.out.println(STR."you are paying using default option,amount:\{bill.getAmount()}");
    }
}
