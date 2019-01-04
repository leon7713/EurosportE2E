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
    By categoryList = By.xpath("//*[contains(@class, \"categorylist__item\")]");
    By moreBtn = By.xpath("//*[@class = \"categorylist__item categorylist__item--sports\"]/a");
    By legalNotices = By.className("legal-notice-menu__title");
    By termsAndConditions = By.xpath("//li/a[text() = \"Terms and Conditions\"]");
    By privacyPolicy = By.xpath("//li/a[text() = \"Privacy Policy\"]");
    By cookiePolicy = By.xpath("//li/a[text() = \"Cookie Policy\"]");
    By footbalBtn = By.linkText("Football");



    public WebElement getMainLogo() {
        return driver.findElement(mainLogo);
    }

    public void scrolltoLegalNotice () {
        WebElement legalNotice = driver.findElement(By.className("legal-notice-menu__title"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",legalNotice);
    }

    public int getCategoryListNumber () {
        return driver.findElements(categoryList).size();
    }

    public WebElement getMoreBtn () {
        return driver.findElement(moreBtn);
    }

    public WebElement getLegalNotices () { return  driver.findElement(legalNotices); }
    public WebElement getPrivacyPolicy () { return  driver.findElement(privacyPolicy); }
    public WebElement getCookiePolicy () { return  driver.findElement(cookiePolicy); }
    public WebElement getFootballBtn () { return driver.findElement(footbalBtn); } // continue from here!!!
}
