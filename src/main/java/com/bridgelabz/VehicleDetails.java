package com.bridgelabz;

public class VehicleDetails {
    private VehicleDetails.VehicleType vehicleType;
    private String vehicleName;
    private String vehicleNumber;
    private String startTime;
    private String endTime;
    private ParkingLotArea.DriverType driverType;

    enum VehicleType {
        CAR;
    }

    public VehicleDetails(ParkingLotArea.DriverType driverType, VehicleDetails.VehicleType vehicleType, String vehicleName, String vehicleNumber) {
        this.driverType = driverType;
        this.vehicleType = vehicleType;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleDetails(ParkingLotArea.DriverType driverType, VehicleType vehicleType, String vehicleName, String vehicleNumber, String startTime, String endTime) {
        this.driverType = driverType;
        this.vehicleType = vehicleType;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    String getEndTime() {
        return endTime;
    }

    String getStartTime() {
        return startTime;
    }

    VehicleType getVehicleType() {
        return vehicleType;
    }

    public ParkingLotArea.DriverType getDriverType() {
        return driverType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof VehicleDetails)) return false;
        VehicleDetails vehicle = (VehicleDetails) o;
        return vehicleName.equals(vehicle.vehicleName) &&
                vehicleNumber.equals(vehicle.vehicleNumber);
    }
}