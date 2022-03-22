package com.vytrack.tests;

import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Model;

import java.util.concurrent.TimeUnit;

public class US70 {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        BrowserUtils.sleep(5);

        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env1"));

    }

    @Test(priority = 1)
    public void vehicle_model_message_display_verification_as_driver() {
        //AC #2: Drivers should not able to access the Vehicle Model page,
        //users should see “You do not have permission to perform this action.”

        //Go to : login page, use driver login credentials
        //VytrackUtils.login("user12", "UserUser123");
        VytrackUtils.login(ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty("driver_password"));
        BrowserUtils.sleep(3);
        //BrowserUtils.sleep(5);

        //locate Fleet link
        WebElement fleetLink = driver.findElement(By.xpath("//span[@class='title title-level-1']"));

        BrowserUtils.sleep(5);

        //hover over Fleet link
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetLink).perform();

        BrowserUtils.sleep(5);

        //locate Vehicles Model link and click
        WebElement vehiclesModelLink = driver.findElement(By.linkText("Vehicles Model"));
        vehiclesModelLink.click();

        //locate the warning message in opening page
        WebElement warningMessage = driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));

        Assert.assertTrue(warningMessage.isDisplayed());

      Driver.closeDriver();


    }

    @Test (priority = 2)
    public void vehicle_model_page_10_columns_verify_as_store_manager(){
        //AC #1: As store manager you should see 10 columns on the Vehicle Model page.
        //Expected Column names:
        //MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED), TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS

        //Go to : login page, use store manager login credentials
        VytrackUtils.login(ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("store_manager_password"));
        BrowserUtils.sleep(5);

        //locate Fleet link
        WebElement fleetLink = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));

        BrowserUtils.sleep(2);

        //hover over Fleet link
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetLink).perform();

        BrowserUtils.sleep(5);

        //locate Vehicles Model link and click
        WebElement vehiclesModelLink = driver.findElement(By.linkText("Vehicles Model"));
        vehiclesModelLink.click();

        BrowserUtils.sleep(5);

        WebElement vehicleModelsTableHeading1 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-ModelName sortable renderable shortenable-label string-cell']"));
        String actualVehicleModelsTableHeading1Text = vehicleModelsTableHeading1.getText();
        String expectedVehicleModelsTableHeading1Text = "MODEL NAME";

        WebElement vehicleModelsTableHeading2 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-Make sortable renderable shortenable-label string-cell']"));
        String actualVehicleModelsTableHeading2Text = vehicleModelsTableHeading2.getText();
        String expectedVehicleModelsTableHeading2Text = "MAKE";

        WebElement vehicleModelsTableHeading3 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-Canberequested sortable renderable shortenable-label boolean-cell']"));
        String actualVehicleModelsTableHeading3Text = vehicleModelsTableHeading3.getText();
        String expectedVehicleModelsTableHeading3Text = "CAN BE REQUESTED";

        WebElement vehicleModelsTableHeading4 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-CatalogValue sortable renderable number-cell']"));
        String actualVehicleModelsTableHeading4Text = vehicleModelsTableHeading4.getText();
        String expectedVehicleModelsTableHeading4Text = "CVVI";

        WebElement vehicleModelsTableHeading5 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-CO2Fee sortable renderable shortenable-label number-cell']"));
        String actualVehicleModelsTableHeading5Text = vehicleModelsTableHeading5.getText();
        String expectedVehicleModelsTableHeading5Text = "CO2 FEE (/MONTH)";

        WebElement vehicleModelsTableHeading6 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-Cost sortable renderable shortenable-label number-cell']"));
        String actualVehicleModelsTableHeading6Text = vehicleModelsTableHeading6.getText();
        String expectedVehicleModelsTableHeading6Text = "COST (DEPRECIATED)";

        WebElement vehicleModelsTableHeading7 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-TotalCost sortable renderable shortenable-label number-cell']"));
        String actualVehicleModelsTableHeading7Text = vehicleModelsTableHeading7.getText();
        String expectedVehicleModelsTableHeading7Text = "TOTAL COST (DEPRECIATED)";

        WebElement vehicleModelsTableHeading8 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-CO2Emissions sortable renderable shortenable-label number-cell']"));
        String actualVehicleModelsTableHeading8Text = vehicleModelsTableHeading8.getText();
        String expectedVehicleModelsTableHeading8Text = "CO2 EMISSIONS";

        WebElement vehicleModelsTableHeading9 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-FuelType sortable renderable shortenable-label string-cell']"));
        String actualVehicleModelsTableHeading9Text = vehicleModelsTableHeading9.getText();
        String expectedVehicleModelsTableHeading9Text = "FUEL TYPE";

        WebElement vehicleModelsTableHeading10 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-Vendors sortable renderable shortenable-label string-cell']"));
        String actualVehicleModelsTableHeading10Text = vehicleModelsTableHeading10.getText();
        String expectedVehicleModelsTableHeading10Text = "VENDORS";


        Assert.assertTrue(actualVehicleModelsTableHeading1Text.equals(expectedVehicleModelsTableHeading1Text));
        Assert.assertTrue(actualVehicleModelsTableHeading2Text.equals(expectedVehicleModelsTableHeading2Text));
        Assert.assertTrue(actualVehicleModelsTableHeading3Text.equals(expectedVehicleModelsTableHeading3Text));
        Assert.assertTrue(actualVehicleModelsTableHeading4Text.equals(expectedVehicleModelsTableHeading4Text));
        Assert.assertTrue(actualVehicleModelsTableHeading5Text.equals(expectedVehicleModelsTableHeading5Text));
        Assert.assertTrue(actualVehicleModelsTableHeading6Text.equals(expectedVehicleModelsTableHeading6Text));
        Assert.assertTrue(actualVehicleModelsTableHeading7Text.equals(expectedVehicleModelsTableHeading7Text));
        Assert.assertTrue(actualVehicleModelsTableHeading8Text.equals(expectedVehicleModelsTableHeading8Text));
        Assert.assertTrue(actualVehicleModelsTableHeading9Text.equals(expectedVehicleModelsTableHeading9Text));
        Assert.assertTrue(actualVehicleModelsTableHeading10Text.equals(expectedVehicleModelsTableHeading10Text));


        Driver.closeDriver();
    }

    @Test (priority = 3)
    public void vehicle_model_page_10_columns_verify_as_sales_manager(){
        //AC #1: As sales manager, you should see 10 columns on the Vehicle Model page.
        //Expected Column names:
        //MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED), TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS

        //Go to : login page, use store manager login credentials
        VytrackUtils.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty("sales_manager_password"));
        BrowserUtils.sleep(5);

        //Go to : login page, use driver login credentials
        //VytrackUtils.login("storemanager63", "UserUser123");
        //BrowserUtils.sleep(5);

        //locate Fleet link
        WebElement fleetLink = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));

        BrowserUtils.sleep(2);

        //hover over Fleet link
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetLink).perform();

        BrowserUtils.sleep(5);

        //locate Vehicles Model link and click
        WebElement vehiclesModelLink = driver.findElement(By.linkText("Vehicles Model"));
        vehiclesModelLink.click();

        BrowserUtils.sleep(5);

        WebElement vehicleModelsTableHeading1 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-ModelName sortable renderable shortenable-label string-cell']"));
        String actualVehicleModelsTableHeading1Text = vehicleModelsTableHeading1.getText();
        String expectedVehicleModelsTableHeading1Text = "MODEL NAME";

        WebElement vehicleModelsTableHeading2 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-Make sortable renderable shortenable-label string-cell']"));
        String actualVehicleModelsTableHeading2Text = vehicleModelsTableHeading2.getText();
        String expectedVehicleModelsTableHeading2Text = "MAKE";

        WebElement vehicleModelsTableHeading3 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-Canberequested sortable renderable shortenable-label boolean-cell']"));
        String actualVehicleModelsTableHeading3Text = vehicleModelsTableHeading3.getText();
        String expectedVehicleModelsTableHeading3Text = "CAN BE REQUESTED";

        WebElement vehicleModelsTableHeading4 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-CatalogValue sortable renderable number-cell']"));
        String actualVehicleModelsTableHeading4Text = vehicleModelsTableHeading4.getText();
        String expectedVehicleModelsTableHeading4Text = "CVVI";

        WebElement vehicleModelsTableHeading5 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-CO2Fee sortable renderable shortenable-label number-cell']"));
        String actualVehicleModelsTableHeading5Text = vehicleModelsTableHeading5.getText();
        String expectedVehicleModelsTableHeading5Text = "CO2 FEE (/MONTH)";

        WebElement vehicleModelsTableHeading6 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-Cost sortable renderable shortenable-label number-cell']"));
        String actualVehicleModelsTableHeading6Text = vehicleModelsTableHeading6.getText();
        String expectedVehicleModelsTableHeading6Text = "COST (DEPRECIATED)";

        WebElement vehicleModelsTableHeading7 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-TotalCost sortable renderable shortenable-label number-cell']"));
        String actualVehicleModelsTableHeading7Text = vehicleModelsTableHeading7.getText();
        String expectedVehicleModelsTableHeading7Text = "TOTAL COST (DEPRECIATED)";

        WebElement vehicleModelsTableHeading8 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-CO2Emissions sortable renderable shortenable-label number-cell']"));
        String actualVehicleModelsTableHeading8Text = vehicleModelsTableHeading8.getText();
        String expectedVehicleModelsTableHeading8Text = "CO2 EMISSIONS";

        WebElement vehicleModelsTableHeading9 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-FuelType sortable renderable shortenable-label string-cell']"));
        String actualVehicleModelsTableHeading9Text = vehicleModelsTableHeading9.getText();
        String expectedVehicleModelsTableHeading9Text = "FUEL TYPE";

        WebElement vehicleModelsTableHeading10 = driver.findElement(By.xpath("//th[@class='grid-cell grid-header-cell grid-header-cell-Vendors sortable renderable shortenable-label string-cell']"));
        String actualVehicleModelsTableHeading10Text = vehicleModelsTableHeading10.getText();
        String expectedVehicleModelsTableHeading10Text = "VENDORS";


        Assert.assertTrue(actualVehicleModelsTableHeading1Text.equals(expectedVehicleModelsTableHeading1Text));
        Assert.assertTrue(actualVehicleModelsTableHeading2Text.equals(expectedVehicleModelsTableHeading2Text));
        Assert.assertTrue(actualVehicleModelsTableHeading3Text.equals(expectedVehicleModelsTableHeading3Text));
        Assert.assertTrue(actualVehicleModelsTableHeading4Text.equals(expectedVehicleModelsTableHeading4Text));
        Assert.assertTrue(actualVehicleModelsTableHeading5Text.equals(expectedVehicleModelsTableHeading5Text));
        Assert.assertTrue(actualVehicleModelsTableHeading6Text.equals(expectedVehicleModelsTableHeading6Text));
        Assert.assertTrue(actualVehicleModelsTableHeading7Text.equals(expectedVehicleModelsTableHeading7Text));
        Assert.assertTrue(actualVehicleModelsTableHeading8Text.equals(expectedVehicleModelsTableHeading8Text));
        Assert.assertTrue(actualVehicleModelsTableHeading9Text.equals(expectedVehicleModelsTableHeading9Text));
        Assert.assertTrue(actualVehicleModelsTableHeading10Text.equals(expectedVehicleModelsTableHeading10Text));

        Driver.closeDriver();

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

