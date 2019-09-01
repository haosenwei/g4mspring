package com.g4m.util;

import java.io.File;
import java.io.IOException;

public class GPIOControl {
    private int pinNum;
    private String gpioDirectory;
    private File gpioDirectoryFile;
    private String gpioValuePath;
    private String gpioDirectionPath;

    /**
     * GPIOControl's construction method.
     * @param pinNum Your pin index.
     */
    public GPIOControl(int pinNum) {
        setPin(pinNum);
    }

    /**
     * Get this pin's state.
     * @return This is the pin connection state, if connection, it's return true.
     */
    public boolean isExport() {
        return gpioDirectoryFile.exists();
    }

    /**
     * Export this pin.
     * (If your pin is exporting, it will skip.)
     * @throws IOException I/O error.
     */
    public void export() throws IOException {
        if (!isExport()) {
            FileUtil.append(GPIODefine.gpioExportFilePath, String.valueOf(pinNum).getBytes());
        }
    }

    /**
     * UnExport this pin.
     * (If your pin isn't exporting, it will skip.)
     * @throws IOException I/O error.
     */
    public void unExport() throws IOException {
        if (isExport()) {
            FileUtil.append(GPIODefine.gpioUnExportFilePath, String.valueOf(pinNum).getBytes());
        }
    }

    /**
     * Get mode.
     * @return Mode, if isn't exporting, then return fase.
     * @throws IOException
     */
    public byte[] getMode() throws IOException {
        if (isExport()) {
            return FileUtil.readBytes(gpioDirectory);
        }
        return null;
    }

    /**
     * Set mode.
     * @param mode It's your mode, such as OUT, IN.
     * @throws IOException I/O error.
     */
    public void setMode(byte[] mode) throws IOException {
        if (isExport()) {
            FileUtil.append(gpioDirectory, mode);
        }
    }

    /**
     * Set value.
     * @param value It's your value.
     * @throws IOException I/O error.
     */
    public void setValue(byte[] value) throws IOException {
        if (isExport()) {
            FileUtil.replace(gpioValuePath, value);
        }
    }

    /**
     * Get value.
     * @return Value, if isn't exporting, then return null.
     * @throws IOException
     */
    public byte[] getValue() throws IOException {
        if (isExport()) {
            return FileUtil.readBytes(gpioValuePath);
        }
        return null;
    }

    /**
     * Get pin index.
     * @return The pin index in this object.
     */
    public int getPinNum() {
        return pinNum;
    }

    /**
     * Set pin index.
     * @param pinNum Pin index.
     */
    public void setPin(int pinNum) {
        this.pinNum = pinNum;
        gpioDirectory = GPIODefine.gpioRootDirectory + "/gpio" + pinNum;
        gpioDirectoryFile = new File(gpioDirectory);
        gpioValuePath = gpioDirectory + "/" + GPIODefine.gpioValueFileName;
        gpioDirectionPath = gpioDirectory + "/" + GPIODefine.gpioDirectionFileName;
    }
}