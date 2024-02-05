package com.dittrichlucas.factory;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriveManager extends DriverManager {
    private ChromeDriverService chService;
    private String driverPath = "/home/lucas/Downloads/drivers/chromedriver";
    
    @Override
    public void startServices() {
        if (chService == null) {
            try {
                chService = new ChromeDriverService
                    .Builder()
                    .usingDriverExecutable(new File(driverPath))
                    .usingAnyFreePort()
                    .build();
                chService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void stopServices() {
        if (chService != null && chService.isRunning()) {
            chService.stop();
        }
    }
    
    @Override
    public void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(options);
    }
}
