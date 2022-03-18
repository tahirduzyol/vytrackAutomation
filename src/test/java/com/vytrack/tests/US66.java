package com.vytrack.tests;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US66 {

    @BeforeMethod
    public void setUp(){
    Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
    Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void tc1_store_manager() {
        VytrackUtils.loginAsStoreManger();
        WebElement dashboardLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Dashboard')]" ));
        WebElement fleetLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//a/span[contains(text(),'Fleet')]" ));
        WebElement customersLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Customers')]" ));
        WebElement salesLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Sales')]" ));
        WebElement activitiesLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]" ));
        WebElement marketingLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Marketing')]" ));
        WebElement reportsAndSegmentsLink = Driver.getDriver().findElement(By.xpath( "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Report')]"));
        WebElement systemLink = Driver.getDriver().findElement(By.xpath( "//div[@id='main-menu']/ul/li/a/span[contains(text(),'System')]"));
        
        List<WebElement> dashboardLInks = new ArrayList<>(Arrays.asList(dashboardLink, fleetLink,
                customersLink, salesLink, activitiesLink, marketingLink,
                reportsAndSegmentsLink, systemLink));

        List<String> expectedModuleNames = new ArrayList<>(Arrays.asList(
                "Dashboards", "Fleet", "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"
        ));

        List<String> actualModuleNames = new ArrayList<>();
        for (WebElement each : dashboardLInks) {
            actualModuleNames.add(each.getText());
        }

        for (WebElement each : dashboardLInks) {
            Assert.assertTrue(each.isDisplayed());
        }
        Assert.assertEquals(actualModuleNames,expectedModuleNames);
    }

    @Test
    public void tc1_sales_manager() {
        VytrackUtils.loginAsSalesManager();
        WebElement dashboardLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Dashboard')]" ));
        WebElement fleetLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//a/span[contains(text(),'Fleet')]" ));
        WebElement customersLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Customers')]" ));
        WebElement salesLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Sales')]" ));
        WebElement activitiesLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]" ));
        WebElement marketingLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Marketing')]" ));
        WebElement reportsAndSegmentsLink = Driver.getDriver().findElement(By.xpath( "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Report')]"));
        WebElement systemLink = Driver.getDriver().findElement(By.xpath( "//div[@id='main-menu']/ul/li/a/span[contains(text(),'System')]"));

        List<WebElement> dashboardLInks = new ArrayList<>(Arrays.asList(dashboardLink, fleetLink,
                customersLink, salesLink, activitiesLink, marketingLink,
                reportsAndSegmentsLink, systemLink));

        List<String> expectedModuleNames = new ArrayList<>(Arrays.asList(
                "Dashboards", "Fleet", "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"
        ));

        List<String> actualModuleNames = new ArrayList<>();
        for (WebElement each : dashboardLInks) {
            actualModuleNames.add(each.getText());
        }

        for (WebElement each : dashboardLInks) {
            Assert.assertTrue(each.isDisplayed());
        }
        Assert.assertEquals(actualModuleNames,expectedModuleNames);
    }

    @Test
    public void tc2_truck_driver() {
        VytrackUtils.loginAsDriver();
        WebElement fleetLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']//a/span[contains(text(),'Fleet')]" ));
        WebElement customersLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Customers')]" ));
        WebElement activitiesLink = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]" ));
        WebElement systemLink = Driver.getDriver().findElement(By.xpath( "//div[@id='main-menu']/ul/li/a/span[contains(text(),'System')]"));

        List<WebElement> driver_dashboardLInks = new ArrayList<>(Arrays.asList(fleetLink,customersLink,activitiesLink,systemLink));

        List<String> expectedModuleNames = new ArrayList<>(Arrays.asList(
                "Fleet", "Customers", "Activities", "System"
        ));

        List<String> actualModuleNames = new ArrayList<>();
        for (WebElement each : driver_dashboardLInks) {
            actualModuleNames.add(each.getText());
        }

        for (WebElement each : driver_dashboardLInks) {
            Assert.assertTrue(each.isDisplayed());
        }
        Assert.assertEquals(actualModuleNames,expectedModuleNames);
    }

}