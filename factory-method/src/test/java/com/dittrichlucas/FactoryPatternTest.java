package com.dittrichlucas;

import com.dittrichlucas.factory.DriverManager;
import com.dittrichlucas.factory.DriverManagerFactory;
import com.dittrichlucas.factory.DriverType;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FactoryPatternTest {
    DriverManager driverManager;
    WebDriver driver;
    
    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
    }
    
    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }
    
    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }
    
    @Test
    public void navigateToFacebook() {
        driver.get("https://www.facebook.com");
        Assert.assertEquals("Facebook - Log In or Sign Up", driver.getTitle());
    }
    
    @Test
    public void navigateToGoogle() {
        driver.get("https://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
    }
}
