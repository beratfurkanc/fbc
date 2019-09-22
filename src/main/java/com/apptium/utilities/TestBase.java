package com.apptium.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public Pages pages;

    @BeforeMethod()
    public void setup() {
        driver = Driver.get();
        pages = new Pages();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));
    }

    @AfterMethod()
    public void teardown() {
        Driver.closeDriver();
    }
}
