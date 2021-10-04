package com.bridgelabz;

public class ParkingLotSystem {
    private ParkingLotObserver parkingLotObserver;
    private int actualCapacity;
    private Object vehicle = null;

    public ParkingLotSystem() {
        parkingLotObserver = new ParkingLotObserver();
    }

    public void setActualCapacity(int actualCapacity) {
        parkingLotObserver.setActualCapacity(actualCapacity);
    }

    public boolean park(Vehicle vehicle) throws ParkingLotException {
        boolean isCapacity = parkingLotObserver.isCapacityFull();
        if (isCapacity) {
            parkingLotObserver.addVehicle(vehicle);
            return true;
        } else throw new ParkingLotException("parkingLot is full");
    }

    public boolean unParked(Vehicle vehicle) throws ParkingLotException {
        boolean isAvailable = parkingLotObserver.isVehicleAvailable(vehicle);
        if (isAvailable) {
            parkingLotObserver.removeVehicle(vehicle);
            return true;
        } else throw new ParkingLotException("vehicle not parked yet");
    }
}
