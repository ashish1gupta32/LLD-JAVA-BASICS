package lld.CarRentalSystem;

import lld.CarRentalSystem.product.Vehicle;
import lld.CarRentalSystem.product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final int storeId;
    private final VehicleInvMgmt inventoryManagement;
    private Location location;
    private List<Reservation> reservationList;

    public Store(int storeId, VehicleInvMgmt inventoryManagement, Location location) {
        this.storeId = storeId;
        this.inventoryManagement = inventoryManagement;
        this.location = location;
        this.reservationList = new ArrayList<>();
    }
    void addReservation(Reservation reservation){
        reservationList.add(reservation);
    }
    void removeReservation(Reservation reservation){
        reservationList.remove(reservation);
    }

    public List<Vehicle> getVehicle(){
        return inventoryManagement.getVehicle();
    }
    public List<Vehicle> getVehicle(VehicleType vehicleType){
        return inventoryManagement.getVehicle(vehicleType);
    }


    public int getStoreId() {
        return storeId;
    }

    public VehicleInvMgmt getInventoryManagement() {
        return inventoryManagement;
    }

    public Location getLocation() {
        return location;
    }
}
