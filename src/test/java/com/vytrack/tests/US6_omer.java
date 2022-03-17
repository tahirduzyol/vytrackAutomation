package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US6_omer {

    @Test
    public void view_edit_car_info_icons_from_Vehicle_page() {
        Driver.getDriver().get("https://qa1.vytrack.com/user/login");
        VytrackUtils.loginAsDriver();
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"))).perform();
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.linkText("Vehicles")).click();
        BrowserUtils.sleep(4);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("(//a[text()='...'])[1]"))).perform();
        //WebElement editOption=Driver.getDriver().findElement(By.xpath("((//ul[@class='nav nav-pills icons-holder launchers-list'])[1]//li)[2]"));
        List<WebElement> listOfOptions=Driver.getDriver().findElements(By.xpath("(//ul[@class='nav nav-pills icons-holder launchers-list'])[1]//li"));
        for(WebElement each:listOfOptions) {
            Assert.assertTrue(each.isDisplayed());

        }
        Driver.closeDriver();
    }



}
