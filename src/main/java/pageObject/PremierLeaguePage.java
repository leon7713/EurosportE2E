package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class PremierLeaguePage {
    public WebDriver driver;

    public PremierLeaguePage(WebDriver driver) {
        this.driver = driver;
    }

    By premierLeagueLogo = By.xpath("//h1//*[text() = \"Premier League\"]");

    public WebElement getPremierLeagueLogo() {
        return driver.findElement(premierLeagueLogo);
    }

    public void verifyCatNumb(int catNumb) {

        for (int i = 1; i <= catNumb; i++) {
            driver.findElement(By.xpath("//*[@class = \"categorylist\"]/li[" + i + "]")).isDisplayed();
        }
    }


    public WebElement getRandomCategory() {
        Random r = new Random();
        int rand = r.nextInt((5 - 1) + 1) + 1; //random from 1 to 5

        return driver.findElement(By.xpath("//*[@class = \"categorylist\"]/li[" + rand + "]"));
    }
}
