package lld.CarRentalSystem.payment;

import lld.CarRentalSystem.Bill;

public class UPIPayment extends Payment{
    @Override
    public void PayBill(Bill bill){
        bill.setPaid(true);
        System.out.println(STR."you are paying using UPI option,amount:\{bill.getAmount()}");
    }
}
