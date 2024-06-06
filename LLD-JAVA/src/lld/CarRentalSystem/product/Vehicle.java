package lld.CarRentalSystem.product;

import static lld.CarRentalSystem.product.VehicleStatus.ACTIVE;

public class Vehicle {
    int id;
    String vehicleNo;
    VehicleType vehicleType;
    VehicleStatus vehicleStatus;
    String ModelNo;
    int perDayBookingCost;

    public Vehicle(int id, String vehicleNo, VehicleType vehicleType, int perDayBookingCost) {
        this.id = id;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.vehicleStatus = ACTIVE;
        this.perDayBookingCost = perDayBookingCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getModelNo() {
        return ModelNo;
    }

    public void setModelNo(String modelNo) {
        ModelNo = modelNo;
    }

    public int getPerDayBookingCost() {
        return perDayBookingCost;
    }

    public void setPerDayBookingCost(int perDayBookingCost) {
        this.perDayBookingCost = perDayBookingCost;
    }

    @Override
    public String toString() {
        return STR."Vehicle{id=\{id}, vehicleNo='\{vehicleNo}\{'\''}, vehicleType=\{vehicleType}, vehicleStatus=\{vehicleStatus}, ModelNo='\{ModelNo}\{'\''}, perDayBookingCost=\{perDayBookingCost}\{'}'}";
    }
}
