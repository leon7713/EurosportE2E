package pages.mainSideMenuPages.underHelpPagePages;

import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class ContactUsPage extends Page {

    public void validateMainTitle() {
        isElementDisplayed("mainTitleCUP_CSS");
    }

    public void selectRandomItem() throws InterruptedException{
        Random rand = new Random();
        int r = rand.nextInt((5 - 1) + 1) + 1;
        System.out.println("Random is: " + r);
        Thread.sleep(2000);
        driver.findElement(By.xpath(OR.getProperty("selectField_XPATH"))).click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);

        for (int i = 0; i < r; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            Thread.sleep(1000);
        }

        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);
        WebElement SubmitBtn = driver.findElement(By.xpath(OR.getProperty("SubmitBtn_XPATH")));
        actions.moveToElement(SubmitBtn).build().perform();
        isElementDisplayed(OR.getProperty("SubmitBtn_XPATH"));
    }

}
