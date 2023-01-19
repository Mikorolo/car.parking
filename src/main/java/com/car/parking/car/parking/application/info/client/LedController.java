package com.car.parking.car.parking.application.info.client;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputConfig;
import com.pi4j.io.gpio.digital.DigitalOutputConfigBuilder;
import com.pi4j.io.gpio.digital.DigitalState;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/led")
public class LedController {
    // private static GpioPinDigitalOutput pin;
    private static final int PIN_LED_RESERVATION = 23;
    private static final int PIN_LED_OCCUPY = 4;

    private static Context pi4jReservation = Pi4J.newAutoContext();

    private static Context pi4jOccupy = Pi4J.newAutoContext();

    private static DigitalOutputConfigBuilder reservationConfig = DigitalOutput.newConfigBuilder(pi4jReservation)
            .id("ledReservation")
            .name("LED Reservation")
            .address(PIN_LED_RESERVATION)
            .shutdown(DigitalState.LOW)
            .initial(DigitalState.LOW)
            .provider("pigpio-digital-output");

    DigitalOutput ledReservation = pi4jReservation.create(reservationConfig);

    private static DigitalOutputConfigBuilder occupyConfig = DigitalOutput.newConfigBuilder(pi4jOccupy)
            .id("ledOccupy")
            .name("LED Occupy")
            .address(PIN_LED_OCCUPY)
            .shutdown(DigitalState.LOW)
            .initial(DigitalState.LOW)
            .provider("pigpio-digital-output");

    DigitalOutput ledOccupy = pi4jOccupy.create(occupyConfig);

    @RequestMapping("/reservation/on")
    public String reservationOn() {
        ledReservation.high();

        return "Reservation ON";
    }

    @RequestMapping("/reservation/off")
    public String reservationOff() {
        ledReservation.low();

        return "Reservation OFF";
    }

    @RequestMapping("/occupy/on")
    public String occupyOn() {
        ledOccupy.high();

        return "Occupy ON";
    }

    @RequestMapping("/occupy/off")
    public String occupyOff() {
        ledOccupy.low();

        return "Occupy OFF";
    }

    static void sleep(int z) {

        try {
            Thread.sleep(z);
        } catch (InterruptedException ex) {
            System.out.println("Thread.sleep");
        }
    }
}
