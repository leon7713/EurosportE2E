package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By mainLogo = By.className("header-logo");


    public WebElement getMainLogo() {
        return driver.findElement(mainLogo);
    }
}
