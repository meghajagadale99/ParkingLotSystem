package com.bridgelabz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotSystemTest {
    private ParkingLotSystem parkingLotSystem;
    private Object vehicle;

    @BeforeEach
    void setUp() {
        vehicle = new Object();
        parkingLotSystem = new ParkingLotSystem();
    }

    @Test
    void givenVehicle_WhenParked_ShouldReturnTrue() throws ParkingLotException {
        boolean isParked = parkingLotSystem.park(vehicle);
        assertTrue(isParked);
    }


    @Test
    void givenAVehicle_WhenAlreadyParked_ShouldReturnFalse() throws ParkingLotException {
        parkingLotSystem.park(vehicle);
        boolean isParked = parkingLotSystem.park(vehicle);
        assertFalse(isParked);
    }

    @Test
    void givenNoVehicle_ParkedShouldReturnException() {
        try {
            parkingLotSystem.park(null);
        } catch (ParkingLotException e) {
            assertEquals("vehicle not found", e.getMessage());
        }
    }
}
