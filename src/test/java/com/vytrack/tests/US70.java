package com.vytrack.tests;

import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US70 {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));

    }

    @Test(priority = 1)
    public void verify() {
        //Go to : login page

        BrowserUtils.sleep(3);
    }

}

/*

User Story

As a user, I want to view columns on the Vehicle models page.(web-table)

*/
