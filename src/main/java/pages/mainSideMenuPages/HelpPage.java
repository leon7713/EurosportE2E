package pages.mainSideMenuPages;

import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class HelpPage extends Page {

    public void validateMainTitle() {
        isElementDisplayed("mainTitleHP_CN");
    }

    public void performSearch() throws InterruptedException{
        type("searchFieald_XPATH", "Subscribe");
        Thread.sleep(2000);
        driver.findElement(By.className(OR.getProperty("mainTitleHP_CN"))).click();
        driver.findElement(By.xpath(OR.getProperty("searchFieald_XPATH"))).sendKeys(Keys.ENTER);
        String subscriberResultAct = driver.findElement(By.xpath(OR.getProperty("subscriberResult_XPATH"))).getText();
        Assert.assertEquals(subscriberResultAct, OR.getProperty("subscriberResult"));
    }
}
