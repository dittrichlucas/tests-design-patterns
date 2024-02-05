package com.dittrichlucas.factory;

public class DriverManagerFactory {
    public static DriverManager getManager(DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case FIREFOX:
                driverManager = new FirefoxDriveManager();
                break;
            default:
                driverManager = new ChromeDriveManager(); 
                break;
        }
        
        return driverManager;
    }
}
