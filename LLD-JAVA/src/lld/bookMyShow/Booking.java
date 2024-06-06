package lld.bookMyShow;

import java.util.List;

public class Booking {
    int bookingId;
    Show show;
    List<Seat> seats;
    Payment payment;

    public Booking(int bookingId, Show show, List<Seat> seats, Payment payment) {
        this.bookingId = bookingId;
        this.show = show;
        this.seats = seats;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return STR."Booking{bookingId=\{bookingId}, \nshow=\{show}, \nseats=\{seats}\{'}'}";
    }
}
