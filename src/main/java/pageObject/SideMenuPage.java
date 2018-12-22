package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenuPage {
    public WebDriver driver;

    public SideMenuPage (WebDriver driver) {
        this.driver = driver;
    }

    By eurosportLogo = By.className("nav__logo");

    public WebElement getEurosportLogo () {
        return driver.findElement(eurosportLogo);
    }
}
