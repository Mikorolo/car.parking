package com.car.parking.car.parking.application.info.client;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/led")
public class LedController {
    private static GpioPinDigitalOutput pin;

    @RequestMapping("/light")
    public String light() {
        if(pin == null) {
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio
                    .provisionDigitalOutputPin(
                            RaspiPin.GPIO_04,
                            "MyLED",
                            PinState.LOW);
        }
        pin.toggle();
        return "OK";
    }
}
