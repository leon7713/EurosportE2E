package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By mainLogo = By.className("header-logo");
    By categoryList = By.xpath("//*[@class = \"categorylist__item\"]");


    public WebElement getMainLogo() {
        return driver.findElement(mainLogo);
    }

    public void scrolltoLegalNotice () {
        WebElement legalNotice = driver.findElement(By.className("legal-notice-menu__title"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",legalNotice);
    }

    public int getCategoryListNumber () {
        int categoryListNumber = driver.findElements(categoryList).size();
        return categoryListNumber;
    }
}
