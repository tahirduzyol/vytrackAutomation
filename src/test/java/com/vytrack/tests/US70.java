package com.vytrack.tests;

import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Model;

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

    @Test(priority = 2)
    public void vehicle_model_verify() {
        //AC #2: Drivers should not able to access the Vehicle Model page,
        //users should see “You do not have permission to perform this action.”

        //Go to : login page, use driver login credentials
        VytrackUtils.login("user12", "UserUser123");
        BrowserUtils.sleep(3);

        //locate Fleet link
        WebElement fleetLink = driver.findElement(By.xpath("//span[@class='title title-level-1']"));

        BrowserUtils.sleep(2);

        //hover over Fleet link
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetLink).perform();

        BrowserUtils.sleep(2);

        //locate Vehicles Model link and click
        WebElement vehiclesModelLink = driver.findElement(By.linkText("Vehicles Model"));
        vehiclesModelLink.click();

        //locate the warning message in opening page
        WebElement warningMessage = driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));

        Assert.assertTrue(warningMessage.isDisplayed());

    }

    @Test (priority = 1)
    public void vehicle_model_page_10_columns_verify_as_store_manager(){
        //AC #1: The store manager and sales manager should see 10 columns on the Vehicle Model page.
        //Expected Column names:
        //MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED), TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS

        //Go to : login page, use store manager login credentials
        VytrackUtils.login(ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("store_manager_password"));
        BrowserUtils.sleep(3);

        //locate Fleet link
        WebElement fleetLink = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));

        BrowserUtils.sleep(2);

        //hover over Fleet link
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetLink).perform();

        BrowserUtils.sleep(2);

        //locate Vehicles Model link and click
        WebElement vehiclesModelLink = driver.findElement(By.linkText("Vehicles Model"));
        vehiclesModelLink.click();

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.close();
    }

}

/*

User Story

As a user, I want to view columns on the Vehicle models page.(web-table)

AC #1: The store manager and sales manager should see 10 columns on the Vehicle Model page.
Expected Column names:
   MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED), TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS

AC #2: Drivers should not able to access the Vehicle Model page, users should see “You do not have permission to perform this action.”
*/
