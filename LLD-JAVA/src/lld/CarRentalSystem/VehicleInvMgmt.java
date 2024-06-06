package lld.CarRentalSystem;

import lld.CarRentalSystem.product.Vehicle;
import lld.CarRentalSystem.product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class VehicleInvMgmt {
    List<Vehicle> vehicleList;


    public VehicleInvMgmt() {
        vehicleList = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicleList.remove(vehicle);
    }

    public List<Vehicle> getVehicle(VehicleType type) {
        return vehicleList.stream().filter(vehicle -> (vehicle.getVehicleType().equals(type))).toList();
    }
    public List<Vehicle> getVehicle() {
        return vehicleList;
    }
}
