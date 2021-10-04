package com.bridgelabz;

public class ParkingLotSystem {
    private Object vehicle = null;

    public ParkingLotSystem() {

    }

    public boolean park(Object vehicle) throws ParkingLotException {
        if (vehicle == null) throw new ParkingLotException("vehicle not found");
        if (this.vehicle == (vehicle)) {
            return false;
        }
        this.vehicle = vehicle;
        return true;
    }
}
