package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US67_AccessOroincDocumentationPage_Kseniia {
    @Test
    public void oro_documentation_page_access_verification_as_driver() {
        //AC #1: users access the Oronic Documentation page by clicking the question icon.
        // The page URL: https://doc.oroinc.com/

        //1. Driver is on the home page
        VytrackUtils.loginAsDriver();
        String mainHandle = Driver.getDriver().getWindowHandle();

        //2. Driver click on the question icon
        Driver.getDriver().findElement(By.xpath("//i[@class = 'fa-question-circle']")).click();

        //3.Driver switch to new window
        //verify URl https://doc.oroinc.com/
        for(String each: Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(each);

        }
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://doc.oroinc.com/");

    }
    @Test
    public void oro_documentation_page_access_verification_as_salesManager() {
        //AC #1: users access the Oronic Documentation page by clicking the question icon.
        // The page URL: https://doc.oroinc.com/

        //1. Sales manager is on the home page
        VytrackUtils.loginAsSalesManager();

        //2. Sales manager clicks on the question icon
        Driver.getDriver().findElement(By.xpath("//i[@class = 'fa-question-circle']")).click();


        //3.Sales manager switch to new window
        //verify URl https://doc.oroinc.com/
        for(String each: Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(each);
            //System.out.println(Driver.getDriver().getWindowHandle());
        }

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://doc.oroinc.com/");

    }

    @Test
    public void oro_documentation_page_access_verification_as_storeManager() {
        //AC #1: users access the Oronic Documentation page by clicking the question icon.
        // The page URL: https://doc.oroinc.com/

        //1. Store manager is on the home page
        VytrackUtils.loginAsStoreManger();
        BrowserUtils.sleep(5);
        //2. Store manager clicks on the question icon
        Driver.getDriver().findElement(By.xpath("//i[@class = 'fa-question-circle']")).click();

        BrowserUtils.sleep(5);


        //3.Store manager switch to new window
        //verify URl https://doc.oroinc.com/
        for(String each: Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(each);
            //System.out.println(Driver.getDriver().getWindowHandle());
        }

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://doc.oroinc.com/");

    }
}
