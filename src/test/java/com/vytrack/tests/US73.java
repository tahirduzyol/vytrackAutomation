package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.vytrack.utilities.Driver.getDriver;

public class US73 {
   @Test
    public void CalenderClickDriver() {

        VytrackUtils.loginAsDriver();
        WebElement alert = Driver.getDriver().findElement(By.xpath("//*[@id='flash-messages']/div/div/div/div"));
        alert.click();

        Actions actions = new Actions(Driver.getDriver());
        WebElement activitiesButton = getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]"));
        actions.moveToElement(activitiesButton).perform();
        activitiesButton.click();

        BrowserUtils.sleep(1);
        WebElement calenderButton = getDriver().findElement(By.xpath("//span[.='Calendar Events']/../.."));
        actions.moveToElement(calenderButton).perform();
        calenderButton.click();

        BrowserUtils.sleep(1);
        WebElement createCalenderEventButton = getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createCalenderEventButton.click();

        BrowserUtils.sleep(1);
        WebElement repeatButton = getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeatButton.click();

        BrowserUtils.sleep(1);
        WebElement number = getDriver().findElement(By.xpath(" //div[@class='controls recurrence-subview-control__items']/div/label/input[3]"));

        BrowserUtils.sleep(1);
        String actualrepeatnumber = number.getAttribute("value");
        String expectedrepeatnumber = "1";


        Assert.assertEquals(actualrepeatnumber, expectedrepeatnumber);
        Driver.closeDriver();

    }

    @Test()
    public void errorMessageDriver() {
        VytrackUtils.loginAsDriver();


        WebElement alert = Driver.getDriver().findElement(By.xpath("//*[@id='flash-messages']/div/div/div/div"));
        alert.click();
        Actions actions = new Actions(Driver.getDriver());
        WebElement activitiesButton = getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]"));
        actions.moveToElement(activitiesButton).perform();
        activitiesButton.click();

        BrowserUtils.sleep(1);
        WebElement calenderButton = getDriver().findElement(By.xpath("//span[.='Calendar Events']/../.."));
        actions.moveToElement(calenderButton).perform();
        calenderButton.click();

        BrowserUtils.sleep(1);
        WebElement createCalenderEventButton = getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createCalenderEventButton.click();

        BrowserUtils.sleep(1);
        WebElement repeatButton = getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeatButton.click();


        WebElement number = getDriver().findElement(By.xpath(" //div[@class='controls recurrence-subview-control__items']/div/label/input[3]"));
        number.click();
        number.clear();
        BrowserUtils.sleep(2);
        WebElement ErrorMessage = getDriver().findElement(By.xpath("//span[@class='validation-failed']/span/span"));

        System.out.println(ErrorMessage.getText());
        String actualErrorMessage = ErrorMessage.getText();
        String expectedErrotMessage = "This value should not be blank.";
        Assert.assertEquals(actualErrorMessage, expectedErrotMessage);

        Driver.closeDriver();
    }


    @Test
    public void CalenderClickSalesManager() {

        VytrackUtils.loginAsSalesManager();
        WebElement alert = Driver.getDriver().findElement(By.xpath("//*[@id='flash-messages']/div/div/div/div"));
        alert.click();

        Actions actions = new Actions(Driver.getDriver());
        WebElement activitiesButton = getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]"));
        actions.moveToElement(activitiesButton).perform();
        activitiesButton.click();

        BrowserUtils.sleep(1);
        WebElement calenderButton = getDriver().findElement(By.xpath("//span[.='Calendar Events']/../.."));
        actions.moveToElement(calenderButton).perform();
        calenderButton.click();

        BrowserUtils.sleep(1);
        WebElement createCalenderEventButton = getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createCalenderEventButton.click();

        BrowserUtils.sleep(1);
        WebElement repeatButton = getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeatButton.click();

        BrowserUtils.sleep(1);
        WebElement number = getDriver().findElement(By.xpath(" //div[@class='controls recurrence-subview-control__items']/div/label/input[3]"));

        BrowserUtils.sleep(1);
        String actualrepeatnumber = number.getAttribute("value");
        String expectedrepeatnumber = "1";


        Assert.assertEquals(actualrepeatnumber, expectedrepeatnumber);
        Driver.closeDriver();

    }

    @Test()
    public void errorMessageSalesManager() {
        VytrackUtils.loginAsSalesManager();


        WebElement alert = Driver.getDriver().findElement(By.xpath("//*[@id='flash-messages']/div/div/div/div"));
        alert.click();
        Actions actions = new Actions(Driver.getDriver());
        WebElement activitiesButton = getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]"));
        actions.moveToElement(activitiesButton).perform();
        activitiesButton.click();

        BrowserUtils.sleep(1);
        WebElement calenderButton = getDriver().findElement(By.xpath("//span[.='Calendar Events']/../.."));
        actions.moveToElement(calenderButton).perform();
        calenderButton.click();

        BrowserUtils.sleep(1);
        WebElement createCalenderEventButton = getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createCalenderEventButton.click();

        BrowserUtils.sleep(1);
        WebElement repeatButton = getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeatButton.click();


        WebElement number = getDriver().findElement(By.xpath(" //div[@class='controls recurrence-subview-control__items']/div/label/input[3]"));
        number.click();
        number.clear();
        BrowserUtils.sleep(2);
        WebElement ErrorMessage = getDriver().findElement(By.xpath("//span[@class='validation-failed']/span/span"));

        System.out.println(ErrorMessage.getText());
        String actualErrorMessage = ErrorMessage.getText();
        String expectedErrotMessage = "This value should not be blank.";
        Assert.assertEquals(actualErrorMessage, expectedErrotMessage);

        Driver.closeDriver();
    }


    @Test
    public void CalenderClickStoreManager() {

        VytrackUtils.loginAsStoreManger();
        WebElement alert = Driver.getDriver().findElement(By.xpath("//*[@id='flash-messages']/div/div/div/div"));
        alert.click();

        Actions actions = new Actions(Driver.getDriver());
        WebElement activitiesButton = getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]"));
        actions.moveToElement(activitiesButton).perform();
        activitiesButton.click();

        BrowserUtils.sleep(1);
        WebElement calenderButton = getDriver().findElement(By.xpath("//span[.='Calendar Events']/../.."));
        actions.moveToElement(calenderButton).perform();
        calenderButton.click();

        BrowserUtils.sleep(1);
        WebElement createCalenderEventButton = getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createCalenderEventButton.click();

        BrowserUtils.sleep(1);
        WebElement repeatButton = getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeatButton.click();

        BrowserUtils.sleep(1);
        WebElement number = getDriver().findElement(By.xpath(" //div[@class='controls recurrence-subview-control__items']/div/label/input[3]"));

        BrowserUtils.sleep(1);
        String actualrepeatnumber = number.getAttribute("value");
        String expectedrepeatnumber = "1";


        Assert.assertEquals(actualrepeatnumber, expectedrepeatnumber);
        Driver.closeDriver();

    }

    @Test()
    public void errorMessageStoremanager() {
        VytrackUtils.loginAsStoreManger();


        WebElement alert = Driver.getDriver().findElement(By.xpath("//*[@id='flash-messages']/div/div/div/div"));
        alert.click();
        Actions actions = new Actions(Driver.getDriver());
        WebElement activitiesButton = getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]"));
        actions.moveToElement(activitiesButton).perform();
        activitiesButton.click();

        BrowserUtils.sleep(1);
        WebElement calenderButton = getDriver().findElement(By.xpath("//span[.='Calendar Events']/../.."));
        actions.moveToElement(calenderButton).perform();
        calenderButton.click();

        BrowserUtils.sleep(1);
        WebElement createCalenderEventButton = getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createCalenderEventButton.click();

        BrowserUtils.sleep(1);
        WebElement repeatButton = getDriver().findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        repeatButton.click();


        WebElement number = getDriver().findElement(By.xpath(" //div[@class='controls recurrence-subview-control__items']/div/label/input[3]"));
        number.click();
        number.clear();
        BrowserUtils.sleep(2);
        WebElement ErrorMessage = getDriver().findElement(By.xpath("//span[@class='validation-failed']/span/span"));

        System.out.println(ErrorMessage.getText());
        String actualErrorMessage = ErrorMessage.getText();
        String expectedErrotMessage = "This value should not be blank.";
        Assert.assertEquals(actualErrorMessage, expectedErrotMessage);

        Driver.closeDriver();
    }





}

