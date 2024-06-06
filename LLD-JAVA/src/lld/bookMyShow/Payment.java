package lld.bookMyShow;

public class Payment {
    PaymentStatus paymentStatus;

    void payBill(Booking booking) {
        System.out.println(STR."Booking completed for \{booking}");
        paymentStatus = PaymentStatus.PAID;
    }
}
