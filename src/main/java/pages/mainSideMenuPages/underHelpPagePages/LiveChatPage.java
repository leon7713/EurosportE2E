package pages.mainSideMenuPages.underHelpPagePages;

import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LiveChatPage extends Page {

    public void verifyiFrame() throws InterruptedException {
//        int size = driver.findElements(By.tagName("iframe")).size();
//        for (int i = 0; i < size; i++) {
//            driver.switchTo().frame(i);
//            int total = driver.findElements(By.xpath(OR.getProperty("liveChatTitle_XPATH"))).size();
//            System.out.println(total);
//            driver.switchTo().defaultContent();
//        }
        driver.switchTo().frame(1);
        isElementDisplayed("liveChatTitle_XPATH");
        type("inputField_XPATH", "This is a test");
        Thread.sleep(1000);
        click("takeDown_CSS");
        Thread.sleep(1000);

        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement footer = driver.findElement(By.cssSelector(OR.getProperty("footerLegal_CSS")));
        actions.moveToElement(footer).build().perform();
        Thread.sleep(1000);
        isElementDisplayed("footerLegal_CSS");
    }
}
