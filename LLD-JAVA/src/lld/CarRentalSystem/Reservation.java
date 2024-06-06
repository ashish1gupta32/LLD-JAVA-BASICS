package lld.CarRentalSystem;

import lld.CarRentalSystem.product.Vehicle;

import java.util.Date;

import static lld.CarRentalSystem.BookingStatus.SCHEDULED;

public class Reservation {
    private int reservationId;
    private User user;
    private Vehicle vehicle;
    private Date bookingDate;
    private Date bookingFrom;
    private Date bookingTill;
    private BookingStatus bookingStatus;

    public int createReservation(User user, Vehicle vehicle, Date bookingFrom, Date bookingTill) {
        this.reservationId = (int) (Math.random() * 1000);
        this.user = user;
        this.vehicle = vehicle;
        this.bookingFrom = bookingFrom;
        this.bookingTill = bookingTill;
        this.bookingStatus = SCHEDULED;
        this.bookingDate = new Date();
        return reservationId;
    }

    public Date getBookingFrom() {
        return bookingFrom;
    }

    public Date getBookingTill() {
        return bookingTill;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getReservationId() {
        return reservationId;
    }

    @Override
    public String toString() {
        return STR."Reservation{\nreservationId=\{reservationId},\nuser=\{user},\nvehicle=\{vehicle},\nbookingDate=\{bookingDate},\nbookingFrom=\{bookingFrom},\nbookingTill=\{bookingTill},\nbookingStatus=\{bookingStatus}\{'}'}";
    }
}
