package com.vytrack.tests;

import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        driver.get(ConfigurationReader.getProperty("env1"));

    }

    @Test(priority = 1)
    public void vehicle_model_verify() {
        //Go to : login page
        VytrackUtils.login("user12", "UserUser123");
        BrowserUtils.sleep(3);

        WebElement fleetLink = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetLink).perform();

        BrowserUtils.sleep(2);

        //WebElement vehiclesModelLink = driver.findElement(By.xpath("//span[@class='title title-level-1']"));

    }

}

/*

User Story

As a user, I want to view columns on the Vehicle models page.(web-table)

*/
