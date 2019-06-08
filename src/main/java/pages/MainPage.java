package pages;

import base.Page;
import base.SideMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class MainPage extends Page {

    //By footbalBtn = By.linkText("Football");

    public void getMainLogo() {
        isElementDisplayed("mainLogo_CN");
    }

    public void scrolltoLegalNotice() {
        WebElement legalNotice = driver.findElement(By.className(OR.getProperty("legalNotice_CN")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",legalNotice);
    }

    public void verifyCategoryListNumber() {
        verifyEquals("mainCatNumber", "categoryList_XPATH");
    }

    public SideMenuPage getMoreBtn() {
        click("moreBtn_XPATH");
        return new SideMenuPage();
    }

    public void getLegalNotices() {
        isElementDisplayed("legalNotices_CN");
    }

    public void getPrivacyPolicy() {
        isElementDisplayed("privacyPolicy_XPATH");
    }

    public void getCookiePolicy() {
        isElementDisplayed("cookiePolicy_XPATH");
    }

    public FootballPage getFootballBtn() throws IOException {
        click("footbalBtn_LT");
        return new FootballPage();
    }

    public SideMenuPage clickOnHamburgerBtn() {
        click("hamburger_CSS");
        return new SideMenuPage();
    }

    public LoginPage getLoginPage() {
        click("loginIcon_XPATH");
        return new LoginPage();
    }
}
