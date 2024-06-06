package lld.CarRentalSystem;

import java.time.Duration;
import java.util.Calendar;

public class Bill {
    private int billID;
    private Reservation reservation;

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    private boolean isPaid;
    private double amount;

    public Bill(Reservation reservation) {
        this.billID = (int) (Math.random() * 1000);
        this.reservation = reservation;
        this.isPaid = false;
        this.amount = computeBillAmount(reservation);

    }

    private double computeBillAmount(Reservation reservation) {
        Duration duration = Duration.between(reservation.getBookingFrom().toInstant(), reservation.getBookingTill().toInstant());
        return duration.toDays() * (reservation.getVehicle().getPerDayBookingCost());
//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.setTime(reservation.getBookingFrom());
//        Calendar calendar2 = Calendar.getInstance();
//        calendar2.setTime(reservation.getBookingTill());
//        calendar1.get(Calendar.DAY_OF_YEAR)
//        return 100.00;
    }

    public double getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        return STR."Bill{billID=\{billID}, reservation=\{reservation.getReservationId()}, isPaid=\{isPaid}, amount=\{amount}\{'}'}";
    }
}
