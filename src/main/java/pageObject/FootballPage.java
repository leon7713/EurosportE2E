package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FootballPage {
    public WebDriver driver;

    public FootballPage(WebDriver driver) {
        this.driver = driver;
    }

    By footballLogo = By.linkText("Football");
    //By mainCategories = By.xpath("//*[@class = \"categorylist\"]/li[]");

    public WebElement getFootballLogo() {
        return driver.findElement(footballLogo);
    }

    public boolean verifyMainCatVisibility(int x) {
        boolean result = true;
        for (int i = 0; i < x; i++) {
            if (!driver.findElement(By.xpath("//*[@class = \"categorylist\"]/li[" + x + "]")).isDisplayed()) {
                result = false;
            }
        }
        return result;
    }
}
