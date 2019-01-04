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
    By sideMenuCategories = By.xpath("//*[contains(@class, \"modalnav__leftcol-item\")]");
    By aboutUsCat = By.xpath("//div[@class = \"modalnav__rightcol-list\"]/ul[3]/li[@class = \"modalnav__rightcol-item\"]\n");

    public WebElement getEurosportLogo () {
        return driver.findElement(eurosportLogo);
    }

    public int getSideMenuCategories () {
        return driver.findElements(sideMenuCategories).size();
    }

    public int getAboutUsCat () {
        return driver.findElements(aboutUsCat).size();
    }
}
