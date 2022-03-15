package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US75_CreatingCalenderEvent_Cemil {

    @Test(priority = 1)

    public void create_CalendarEvent_As_A_salesManager (){
        //creating a login as a Sales Manager
        VytrackUtils.loginAsSalesManager();

        BrowserUtils.sleep(3);

        //Locating Activities Button and Perform on it(Click)
        WebElement activitiesButton =
                Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]"));
        activitiesButton.click();

        //Locating Calender Events from Activities Menu and click
        WebElement calenderEventsButton = Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']/../.."));
        calenderEventsButton.click();

        BrowserUtils.sleep(3);

        //Locating Create Event Button and click
        WebElement createEventButton =
                Driver.getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createEventButton.click();


        //Locating the Title Box and entering Title.
        WebElement titleBox =
                Driver.getDriver().findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']"));
        titleBox.sendKeys("Test");



        // Locating the I frame and Switching to I frame in order to send a msg
        WebElement iframeBox = Driver.getDriver().findElement(By.xpath("//iframe"));
        Driver.getDriver().switchTo().frame(iframeBox);



        // Creating the Text to send in Description Box and Sending a msg..
        String text = "Study Time is at 11Pm";
        WebElement textBox = Driver.getDriver().findElement(By.xpath("//body"));
        textBox.sendKeys(text);

        //Getting a Validation
        String actualMessage = Driver.getDriver().findElement(By.xpath("//p")).getText();
        Assert.assertEquals(actualMessage,text);

        //Switching back to Parent Frame
        Driver.getDriver().switchTo().parentFrame();

        //Saving The Event and Closing the input Box
        WebElement saveAndCloseButton =
                Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-success action-button']"));
        saveAndCloseButton.click();

    }


    @Test(priority = 2)
    public void create_CalendarEvent_As_A_storeManager(){

        //creating a login as a Store Manager
        VytrackUtils.loginAsStoreManger();

        BrowserUtils.sleep(3);

        //Locating Activities Button and Perform on it(Click)
        WebElement activitiesButton =
                Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]"));
        activitiesButton.click();

        //Locating Calender Events from Activities Menu and click
        WebElement calenderEventsButton = Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']/../.."));
        calenderEventsButton.click();

        BrowserUtils.sleep(3);

        //Locating Create Event Button and click
        WebElement createEventButton =
                Driver.getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createEventButton.click();


        //Locating the Title Box and entering Title.
        WebElement titleBox =
                Driver.getDriver().findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']"));
        titleBox.sendKeys("Test");



        // Locating the I frame and Switching to I frame in order to send a msg
        WebElement iframeBox = Driver.getDriver().findElement(By.xpath("//iframe"));
        Driver.getDriver().switchTo().frame(iframeBox);



        // Creating the Text to send in Description Box and Sending a msg..
        String text = "Study Time is at 11Pm";
        WebElement textBox = Driver.getDriver().findElement(By.xpath("//body"));
        textBox.sendKeys(text);

        //Getting a Validation
        String actualMessage = Driver.getDriver().findElement(By.xpath("//p")).getText();
        Assert.assertEquals(actualMessage,text);

        //Switching back to Parent Frame
        Driver.getDriver().switchTo().parentFrame();

        //Saving The Event and Closing the input Box
        WebElement saveAndCloseButton =
                Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-success action-button']"));
        saveAndCloseButton.click();

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }




}
