package com.g4m.util;

import com.pi4j.io.gpio.*;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author haosenwei[haosenwei@dubmic.com]
 * @date 8/29/19 11:36
 * <p>Copyright 2008-2019 snsndk.com</p>
 */
@Component
public class GpioUtil {
    // create gpio controller
    private static GpioController gpio = GpioFactory.getInstance();
    final static List<Pin> list = new ArrayList<>();

    final static Map<Integer, GpioPinDigitalOutput> pinMap = new HashMap<>();
    final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.LOW);

    static {
        list.addAll(Arrays.asList(RaspiPin.allPins()));
    }


    public boolean setValue(int io, int status) {
        if (io == 1) {
            if (status == 1) {
                pin.setState(PinState.HIGH);
            } else {
                pin.setState(PinState.LOW);
            }
            return true;
        }
        try {
            GpioPinDigitalOutput gpioPinDigitalOutput = null;
            Pin pin = null;
            if (pinMap.containsKey(io)) {
                gpioPinDigitalOutput = pinMap.get(io);
            } else {
                gpioPinDigitalOutput = gpio.provisionDigitalOutputPin(pin);
                pinMap.put(io, gpioPinDigitalOutput);
            }
            if (status == 1 && gpioPinDigitalOutput.getState() == PinState.LOW) {
                gpioPinDigitalOutput.setState(PinState.HIGH);
            } else {
                if (gpioPinDigitalOutput.getState() == PinState.HIGH) {
                    gpioPinDigitalOutput.setState(PinState.LOW);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private Pin getPin(int io) {
        return list.get(io);
    }

    public Map<Integer, Object> getValue() {
        Map<Integer, Object> map = new HashMap<>();
        for (GpioPinDigitalOutput gpioPinAnalogInput : pinMap.values()) {
            try {
                int address = gpioPinAnalogInput.getPin().getAddress();
                map.put(address, gpioPinAnalogInput.getProperties());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public boolean clear() {
        gpio.shutdown();
        gpio = GpioFactory.getInstance();
        pinMap.clear();
        return true;
    }
}
