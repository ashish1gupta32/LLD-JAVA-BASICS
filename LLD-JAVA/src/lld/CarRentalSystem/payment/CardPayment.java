package lld.CarRentalSystem.payment;

import lld.CarRentalSystem.Bill;

public class CardPayment extends Payment{

    @Override
    public void PayBill(Bill bill){
        bill.setPaid(true);
        System.out.println(STR."you are paying using default option,amount:\{bill.getAmount()}");
    }
}
