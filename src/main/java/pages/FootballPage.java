package pages;

import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class FootballPage extends Page {

    public FootballPage() throws IOException {}


    By footballLogo = By.linkText("Football");
    By premierLeagueBtn = By.xpath("//li[@class = \"categorylist__item\"]/*[contains(text(), \"Premier League\")]");

    public WebElement getFootballLogo() {
        return driver.findElement(footballLogo);
    }
    public WebElement getPremierLeagueBtn() { return driver.findElement(premierLeagueBtn); }

    public boolean verifyMainCatVisibility(int x) {
        boolean result = true;
        for (int i = 1; i <= x; i++) {
            if (!driver.findElement(By.xpath("//*[@class = \"categorylist\"]/li[" + i + "]")).isDisplayed()) {
                result = false;
            }
        }
        return result;
    }
}
