package pages.conditionsAndPolicyPages;

import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PrivacySettingsPage extends Page {

    public void validateMainTitle() {
        isElementDisplayed("mainTitle_XPATH");
    }

    public void measurement_On_Off() throws InterruptedException {
        WebElement toggle = driver.findElement(By.xpath(OR.getProperty("measurementToggleOff_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toggle);
        Thread.sleep(2000);
        click("measurementToggleOff_XPATH");
        String toggleStatus = driver.findElement(By.xpath(OR.getProperty("toggleStatus_XPATH"))).getText();
        Assert.assertEquals(toggleStatus, "On");
        Thread.sleep(1000);
        click("measurementToggleOn_XPATH");
        toggleStatus = driver.findElement(By.xpath(OR.getProperty("toggleStatus_XPATH"))).getText();
        Assert.assertEquals(toggleStatus, "Off");
    }

    public void verifyVendorsNumber(String vendorsNumb) throws InterruptedException{
        click("vendorList_XPATH");
        int vendorsCount = driver.findElements(By.cssSelector(OR.getProperty("vendorRow_CSS"))).size();
        Assert.assertEquals(vendorsCount, Integer.parseInt(vendorsNumb));
        Thread.sleep(2000);
        click("backBtn_CSS");
        Thread.sleep(2000);
        isElementDisplayed("mainTitle_XPATH");
        //more to check?
    }
}
