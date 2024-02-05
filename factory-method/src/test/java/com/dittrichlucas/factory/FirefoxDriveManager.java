package com.dittrichlucas.factory;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriveManager extends DriverManager {
    private GeckoDriverService fService;
    private String driverPath = "/home/lucas/Downloads/drivers/geckodriver";
    
    @Override
    public void startServices() {
        if (fService == null) {
            try {
                fService = new GeckoDriverService
                    .Builder()
                    .usingDriverExecutable(new File(driverPath))
                    .usingAnyFreePort()
                    .build();
                fService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void stopServices() {
        if (fService != null && fService.isRunning()) {
            fService.stop();
        }
    }
    
    @Override
    public void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Firefox");
        FirefoxOptions options = new FirefoxOptions();
        options.merge(capabilities);
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver(options);
    }
}
