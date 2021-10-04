package com.bridgelabz;

import java.text.ParseException;
import java.util.Arrays;

public class ParkingLotSystem  extends ParkingAttendant implements ParkingLotObserver{
    private static final double FARE_PER_SECOND = 0.01d;
    private static final double FARE_PER_MINUTES = 0.18d;
    private static final double FARE_PER_HOURS = 9.83d;
    private static final double FARE_PER_DAYS = 200d;

    public boolean park(VehicleDetails vehicle) throws ParkingLotException {
//        vehicleDataUpdate(vehicle);
        boolean isCapacity = isCapacityNotFull();
        boolean isAvailable = isVehicleAvailable(vehicle);
        if(isCapacity && !isAvailable)
        {
            addVehicle(vehicle);
            return true;
        }
        else if(isAvailable) throw new ParkingLotException("vehicle already parked");
        else throw new ParkingLotException("parkingLot is full");
    }

    public boolean unParked(VehicleDetails vehicle) throws ParkingLotException {
        boolean isAvailable = isVehicleAvailable(vehicle);
        if(isAvailable){
            removeVehicle(vehicle);
            return true;
        }
        else throw new ParkingLotException("vehicle not parked yet");
    }

    public boolean canRedirectSecurityStaff() throws ParkingLotException {
        if(!isCapacityNotFull()) return true;
        else throw new ParkingLotException("parkingLot is not full");
    }

    public String timeTakenToSpaceAgain(String currentTime) throws ParkingLotException, ParseException {
        if(!isCapacityNotFull())
            return timeLeftToSpaceAgain(currentTime);
        else throw new ParkingLotException("parkingLot is not full");
    }

    public double calculateFare(VehicleDetails vehicle) throws ParseException, ParkingLotException {
        int parkingPlotNumber = findParkingPlotNumber(vehicle);
        if(parkingPlotNumber >= 0){
            int index = findParkingSlotNumber(vehicle, parkingPlotNumber);
            long[] time = calculateFare(index);
            return time[0]*FARE_PER_DAYS+time[1]*FARE_PER_HOURS+time[2]*FARE_PER_MINUTES+time[3]*FARE_PER_SECOND;
        }
        else throw new ParkingLotException("vehicle not found");
    }

    @Override
    public boolean isCapacityNotFull() {
        int totalActualCapacity = Arrays.stream(actualCapacity).sum();
        int totalCurrentCapacity = Arrays.stream(currentCapacity).sum();
        return totalCurrentCapacity <= totalActualCapacity && totalCurrentCapacity > 0;
    }
}
