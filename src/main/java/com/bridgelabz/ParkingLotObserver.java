package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotObserver {
    private int actualCapacity;
    private int currentCapacity;
    private double currentTime;
    private List<Vehicle> listOfVehicle = new ArrayList<>();

    void setActualCapacity(int value) {
        this.currentCapacity = value;
        this.actualCapacity = value;
    }

    public void setCurrentTime(double currentTime) {
        this.currentTime = currentTime;
    }

    void addVehicle(Vehicle vehicle) {
        if (listOfVehicle.size() < actualCapacity) {
            listOfVehicle.add(vehicle);
            currentCapacity--;
        }
    }

    void removeVehicle(Vehicle vehicle) {
        int index = -1, count = 0;
        for (Vehicle isVehicle : listOfVehicle) {
            if (isVehicle.equals(vehicle)) {
                index = count;
            }
            count++;
        }
        if (index >= 0) {
            listOfVehicle.remove(index);
            currentCapacity++;
        }
    }

    boolean isCapacityNotFull() {
        return currentCapacity > 0 && currentCapacity <= actualCapacity;
    }

    boolean isVehicleAvailable(Vehicle vehicle) {
        int index = -1, count = 0;
        for (Vehicle isVehicle : listOfVehicle) {
            if (isVehicle.equals(vehicle)) {
                index = count;
            }
            count++;
        }
        return index >= 0;
    }

    public double timeLeftToSpaceAgain() {
        double nearestTime = listOfVehicle.get(0).getEndTime();
        for (Vehicle vehicleData : listOfVehicle) {
            if (nearestTime > vehicleData.getEndTime()) {
                nearestTime = vehicleData.getEndTime();
            }
        }
        return nearestTime - currentTime;
    }
}
