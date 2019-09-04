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

    final GpioPinDigitalOutput pinOut00 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW);
    final GpioPinDigitalOutput pinOut01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.LOW);
    final GpioPinDigitalOutput pinOut02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW);
    final GpioPinDigitalOutput pinOut03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.LOW);
    final GpioPinDigitalOutput pinOut04 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW);
    final GpioPinDigitalOutput pinOut05 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.LOW);
    final GpioPinDigitalOutput pinOut06 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, PinState.LOW);
    final GpioPinDigitalOutput pinOut07 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.LOW);
    //    final GpioPinDigitalOutput pinOut08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, PinState.LOW);
//    final GpioPinDigitalOutput pinOut09 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, PinState.LOW);
//    final GpioPinDigitalOutput pinOut10 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, PinState.LOW);
//    final GpioPinDigitalOutput pinOut11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, PinState.LOW);
//    final GpioPinDigitalOutput pinOut12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, PinState.LOW);
//    final GpioPinDigitalOutput pinOut13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, PinState.LOW);
//    final GpioPinDigitalOutput pinOut14 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, PinState.LOW);
//    final GpioPinDigitalOutput pinOut15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, PinState.LOW);
//    final GpioPinDigitalOutput pinOut16 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, PinState.LOW);
//    final GpioPinDigitalOutput pinOut17 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, PinState.LOW);
//    final GpioPinDigitalOutput pinOut18 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18, PinState.LOW);
//    final GpioPinDigitalOutput pinOut19 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19, PinState.LOW);
//    final GpioPinDigitalOutput pinOut20 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_20, PinState.LOW);
    final GpioPinDigitalOutput pinOut21 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, PinState.LOW);
    final GpioPinDigitalOutput pinOut22 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, PinState.LOW);
    final GpioPinDigitalOutput pinOut23 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, PinState.LOW);
    final GpioPinDigitalOutput pinOut24 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, PinState.LOW);
    final GpioPinDigitalOutput pinOut25 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, PinState.LOW);
    final GpioPinDigitalOutput pinOut26 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, PinState.LOW);
    final GpioPinDigitalOutput pinOut27 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, PinState.LOW);
    final GpioPinDigitalOutput pinOut28 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, PinState.LOW);
    final GpioPinDigitalOutput pinOut29 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, PinState.LOW);
    final GpioPinDigitalOutput pinOut30 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_30, PinState.LOW);


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

            if (io == 21) {
                pinOut21.setState(status);
                return true;
            }
            if (io == 22) {
                pinOut22.setState(status);
                return true;
            }
            if (io == 23) {
                pinOut23.setState(status);
                return true;
            }
            if (io == 24) {
                pinOut24.setState(status);
                return true;
            }
            if (io == 25) {
                pinOut25.setState(status);
                return true;
            }
            if (io == 26) {
                pinOut26.setState(status);
                return true;
            }
            if (io == 27) {
                pinOut27.setState(status);
                return true;
            }
            if (io == 28) {
                pinOut28.setState(status);
                return true;
            }
            if (io == 29) {
                pinOut29.setState(status);
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
        pinOut28.setState(rwStatus);

        PinState rsStatus = PinState.LOW;
        if (rs == 1) {
            rsStatus = PinState.HIGH;
        }
        pinOut29.setState(rsStatus);
    }
}
