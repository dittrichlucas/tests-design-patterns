package com.dittrichlucas.factory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void startServices();
    protected abstract void stopServices();
    protected abstract void createDriver();
    
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
    public WebDriver getDriver() {
        if (driver == null) {
            startServices();
            createDriver();
        }
        return driver;
    }
}
