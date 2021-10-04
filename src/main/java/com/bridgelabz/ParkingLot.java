package com.bridgelabz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLot {
    public List<ParkingSlot> parkingLot = new ArrayList<>();
    public int[] actualCapacity;
    public int[] currentCapacity;

    public void createParkingLot(int number, int... capacity) {
        this.actualCapacity = Arrays.copyOf(capacity, capacity.length);
        this.currentCapacity = Arrays.copyOf(capacity, capacity.length);
        int check = number;
        while (number > 0) {
            ParkingSlot p1 = new ParkingSlot();
            parkingLot.add(p1);
            number--;
        }
    }

    public List<ParkingSlot> getParkingLot() {
        return parkingLot;
    }
}
