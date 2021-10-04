package com.bridgelabz;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotObserver {
    private int actualCapacity;
    private int currentCapacity;
    private int index = -1;
    private final double parkingLotCharge_preHour = 5.60;
    private List<VehicleDetails> listOfVehicle = new ArrayList<>();

    void setActualCapacity(int value) {
        this.currentCapacity = value;
        this.actualCapacity = value;
    }

    void addVehicle(VehicleDetails vehicle) {
//        boolean isUpdateRequired = vehicleDataUpdate(vehicle);
        if (listOfVehicle.size() < actualCapacity) {
            listOfVehicle.add(vehicle);
            currentCapacity--;
        }
    }

    void removeVehicle(VehicleDetails vehicle) {
        findVehicleDetails(vehicle);
        if (index >= 0) {
            listOfVehicle.remove(index);
            currentCapacity++;
        }
    }

    boolean isCapacityNotFull() {
        return currentCapacity > 0 && currentCapacity <= actualCapacity;
    }

    boolean isVehicleAvailable(VehicleDetails vehicle) {
        findVehicleDetails(vehicle);
        return index >= 0;
    }

    String timeLeftToSpaceAgain(String currentTime) throws ParseException, ParseException {
        String endTime = listOfVehicle.get(0).getEndTime();
        for (VehicleDetails v : listOfVehicle) {
            if (endTime.compareTo(v.getEndTime()) > 0) {
                endTime = v.getEndTime();
            }
        }
        return DateAndTime.timeDifference(currentTime, endTime);
    }

    private boolean vehicleDataUpdate(VehicleDetails vehicle) {
        for (VehicleDetails v : listOfVehicle) {
            if (v.getEndTime().compareTo(vehicle.getEndTime()) < 0 || v.getEndTime().compareTo(vehicle.getEndTime()) == 0) {
                return true;
            }
        }
        return false;
    }


    private void findVehicleDetails(VehicleDetails vehicle) {
        int count = 0;
        for (VehicleDetails isVehicle : listOfVehicle) {
            if (isVehicle.equals(vehicle)) {
                index = count;
            }
            count++;
        }
    }
}
