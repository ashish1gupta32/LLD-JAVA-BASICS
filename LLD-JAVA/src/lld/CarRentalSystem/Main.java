package lld.CarRentalSystem;

import lld.CarRentalSystem.payment.Payment;
import lld.CarRentalSystem.payment.UPIPayment;
import lld.CarRentalSystem.product.Vehicle;
import lld.CarRentalSystem.product.VehicleType;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = createUser(1, "abc");
        User user2 = createUser(2, "bcd");

        Vehicle vehicle1 = createVehicle(1, "BR121", 100);
        Vehicle vehicle2 = createVehicle(2, "BR121", 120);
        Vehicle vehicle3 = createVehicle(3, "BR121", 120);

        VehicleInvMgmt vehicleInvMgmt1 = new VehicleInvMgmt();
        VehicleInvMgmt vehicleInvMgmt2 = new VehicleInvMgmt();
        vehicleInvMgmt1.addVehicle(vehicle1);
        vehicleInvMgmt1.addVehicle(vehicle2);
        vehicleInvMgmt2.addVehicle(vehicle3);

        Store store1 = createStore(1, vehicleInvMgmt1);
        Store store2 = createStore(2, vehicleInvMgmt2);

        VehicleRentalService vehicleRentalService = new VehicleRentalService();
        vehicleRentalService.addUser(user1);
        vehicleRentalService.addUser(user2);
        vehicleRentalService.addStore(store1);
        vehicleRentalService.addStore(store2);

        User user = vehicleRentalService.getUser(1);
        Store store = vehicleRentalService.getStore(user);

        List<Vehicle> vehicles = store.getVehicle(VehicleType.CAR);

        Vehicle vehicle = vehicles.get((int) (Math.random() * vehicles.size())); //get Random Vehicle

        Reservation reservation = new Reservation();
        reservation.createReservation(user, vehicle, getBookingFromDate(), getBookingTillDate());

        System.out.println("------------RESERVATION--------------------");
        System.out.println(reservation);

        Bill bill = new Bill(reservation);

        System.out.println("----------------BILL-----------------------");
        System.out.println(bill);

        System.out.println("----------------PAYMENT--------------------");
        Payment upiPayment = new UPIPayment();
        upiPayment.PayBill(bill);

        System.out.println("----------------BILL-----------------------");
        System.out.println(bill);

        store.addReservation(reservation);
    }


    private static User createUser(int id, String username) {
        User user = new User();
        user.setUserId(id);
        user.setUserName(username);
        return user;
    }

    private static Vehicle createVehicle(int id, String vehicleNo, int perDayBookingCost) {
        return new Vehicle(id, vehicleNo, VehicleType.CAR, perDayBookingCost);
    }

    private static Store createStore(int id, VehicleInvMgmt vehicleInvMgmt) {
        Location location = new Location();
        location.setCity("ABC");
        location.setPincode(21991);
        return new Store(id, vehicleInvMgmt, location);

    }

    private static Date getBookingFromDate() {
        Date bookingFrom = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(bookingFrom);
        calendar.add(Calendar.DAY_OF_MONTH, 5 + (int) (Math.random() * 20));
        return calendar.getTime();
    }

    private static Date getBookingTillDate() {
        Date bookingFrom = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(bookingFrom);
        calendar.add(Calendar.DAY_OF_MONTH, 26 + (int) (Math.random() * 20));
        return calendar.getTime();
    }
}
