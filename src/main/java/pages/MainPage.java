package pages;

import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {

    //By mainLogo = By.className("header-logo");
    By categoryList = By.xpath("//*[contains(@class, \"categorylist__item\")]");
    By moreBtn = By.xpath("//*[@class = \"categorylist__item categorylist__item--sports\"]/a");
    By legalNotices = By.className("legal-notice-menu__title");
    By termsAndConditions = By.xpath("//li/a[text() = \"Terms and Conditions\"]");
    By privacyPolicy = By.xpath("//li/a[text() = \"Privacy Policy\"]");
    By cookiePolicy = By.xpath("//li/a[text() = \"Cookie Policy\"]");
    By footbalBtn = By.linkText("Football");


    public void getMainLogo() {
        isElementDisplayed("mainLogo_CN");
    }

    public void scrolltoLegalNotice () {
        WebElement legalNotice = driver.findElement(By.className(OR.getProperty("legalNotice_CN")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",legalNotice);
    }

    public void verifyCategoryListNumber () {
        verifyEquals(OR.getProperty("mainCatNumber"), "categoryList_XPATH");
    }

    public WebElement getMoreBtn () {
        return driver.findElement(moreBtn);
    }

    public void getLegalNotices () {
        isElementDisplayed("legalNotices_CN");
    }

    public void getPrivacyPolicy () {
        isElementDisplayed("privacyPolicy_XPATH");
    }

    public void getCookiePolicy () {
        isElementDisplayed("cookiePolicy_XPATH");
    }

    public WebElement getFootballBtn () {
        return driver.findElement(footbalBtn);
    }
}
