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

    final GpioPinDigitalOutput pinOut00 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW);
    final GpioPinDigitalOutput pinOut01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.LOW);
    final GpioPinDigitalOutput pinOut02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW);
    final GpioPinDigitalOutput pinOut03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.LOW);
    final GpioPinDigitalOutput pinOut04 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW);
    final GpioPinDigitalOutput pinOut05 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.LOW);
    final GpioPinDigitalOutput pinOut06 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, PinState.LOW);
    final GpioPinDigitalOutput pinOut07 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.LOW);
    final GpioPinDigitalOutput pinOut08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, PinState.LOW);
    final GpioPinDigitalOutput pinOut09 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, PinState.LOW);
    final GpioPinDigitalOutput pinOut10 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, PinState.LOW);
    final GpioPinDigitalOutput pinOut11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, PinState.LOW);
    final GpioPinDigitalOutput pinOut12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, PinState.LOW);
    final GpioPinDigitalOutput pinOut13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, PinState.LOW);
    final GpioPinDigitalOutput pinOut14 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, PinState.LOW);
    final GpioPinDigitalOutput pinOut15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, PinState.LOW);
    final GpioPinDigitalOutput pinOut16 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, PinState.LOW);
    final GpioPinDigitalOutput pinOut17 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, PinState.LOW);
    final GpioPinDigitalOutput pinOut18 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18, PinState.LOW);
    final GpioPinDigitalOutput pinOut19 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19, PinState.LOW);
    final GpioPinDigitalOutput pinOut20 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_20, PinState.LOW);


    static {
        list.addAll(Arrays.asList(RaspiPin.allPins()));
    }

    public boolean setValue(int io, PinState status) {

        try {
            if (io == 0) {
                pinOut00.setState(status);
                return true;
            }
            if (io == 1) {
                pinOut01.setState(status);
                return true;
            }
            if (io == 2) {
                pinOut02.setState(status);
                return true;
            }
            if (io == 3) {
                pinOut03.setState(status);
                return true;
            }
            if (io == 4) {
                pinOut04.setState(status);
                return true;
            }
            if (io == 5) {
                pinOut05.setState(status);
                return true;
            }
            if (io == 6) {
                pinOut06.setState(status);
                return true;
            }
            if (io == 7) {
                pinOut07.setState(status);
                return true;
            }
            if (io == 8) {
                pinOut08.setState(status);
                return true;
            }
            if (io == 9) {
                pinOut09.setState(status);
                return true;
            }
            if (io == 10) {
                pinOut10.setState(status);
                return true;
            }
            if (io == 11) {
                pinOut11.setState(status);
                return true;
            }
            if (io == 12) {
                pinOut12.setState(status);
                return true;
            }
            if (io == 13) {
                pinOut13.setState(status);
                return true;
            }
            if (io == 14) {
                pinOut14.setState(status);
                return true;
            }
            if (io == 15) {
                pinOut15.setState(status);
                return true;
            }
            if (io == 16) {
                pinOut16.setState(status);
                return true;
            }
            if (io == 17) {
                pinOut17.setState(status);
                return true;
            }
            if (io == 18) {
                pinOut18.setState(status);
                return true;
            }
            if (io == 19) {
                pinOut19.setState(status);
                return true;
            }
            if (io == 20) {
                pinOut20.setState(status);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public void setLcdValue(int d0, int d1, int d2, int d3, int d4, int d5, int d6, int d7, int rw, int rs) {
        PinState d0Status = PinState.LOW;
        if (d0 == 1) {
            d0Status = PinState.HIGH;
        }
        pinOut00.setState(d0Status);
        PinState d1Status = PinState.LOW;
        if (d1 == 1) {
            d1Status = PinState.HIGH;
        }
        pinOut01.setState(d1Status);
        PinState d2Status = PinState.LOW;
        if (d2 == 1) {
            d2Status = PinState.HIGH;
        }
        pinOut02.setState(d2Status);
        PinState d3Status = PinState.LOW;
        if (d3 == 1) {
            d3Status = PinState.HIGH;
        }
        pinOut03.setState(d3Status);
        PinState d4Status = PinState.LOW;
        if (d4 == 1) {
            d4Status = PinState.HIGH;
        }
        pinOut04.setState(d4Status);
        PinState d5Status = PinState.LOW;
        if (d5 == 1) {
            d5Status = PinState.HIGH;
        }
        pinOut05.setState(d5Status);
        PinState d6Status = PinState.LOW;
        if (d6 == 1) {
            d6Status = PinState.HIGH;
        }
        pinOut06.setState(d6Status);

        PinState d7Status = PinState.LOW;
        if (d7 == 1) {
            d7Status = PinState.HIGH;
        }
        pinOut07.setState(d7Status);

        PinState rwStatus = PinState.LOW;
        if (rw == 1) {
            rwStatus = PinState.HIGH;
        }
        pinOut08.setState(rwStatus);

        PinState rsStatus = PinState.LOW;
        if (rs == 1) {
            rsStatus = PinState.HIGH;
        }
        pinOut09.setState(rsStatus);
    }
}
