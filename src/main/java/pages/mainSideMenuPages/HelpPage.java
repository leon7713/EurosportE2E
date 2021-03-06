package pages.mainSideMenuPages;

import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.mainSideMenuPages.underHelpPagePages.*;

public class HelpPage extends Page {

    public void validateMainTitle() {
        isElementDisplayed("mainTitleHP_CN");
    }

    public void performSearch() throws InterruptedException{

//        int size = driver.findElements(By.tagName("iframe")).size();
//        System.out.println("iframe size is: " + size);

        type("searchFieald_XPATH", "Subscribe");
        Thread.sleep(2000);
        driver.findElement(By.className(OR.getProperty("mainTitleHP_CN"))).click();
        driver.findElement(By.xpath(OR.getProperty("searchFieald_XPATH"))).sendKeys(Keys.ENTER);
        String subscriberResultAct = driver.findElement(By.xpath(OR.getProperty("subscriberResult_XPATH"))).getText();
        Assert.assertEquals(subscriberResultAct, OR.getProperty("subscriberResult"));
        isElementDisplayed("headerSearch_XPATH");
        driver.navigate().back();
    }

    public void changeLanguage() throws InterruptedException{
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        WebElement LangSelector = driver.findElement(By.xpath(OR.getProperty("languageSelector_XPATH")));
        action.moveToElement(LangSelector).build().perform();
        click("languageSelector_XPATH");
        click("dutchLang_XPATH");
        isElementDisplayed("settingsAndDevicesDutch_XPATH");
        WebElement LangSelector_1 = driver.findElement(By.xpath(OR.getProperty("languageSelector_XPATH")));
        action.moveToElement(LangSelector_1).build().perform();
        click("languageSelector_XPATH");
        click("englishLang_XPATH");
        isElementDisplayed("settingsAndDevicesEnglish_XPATH");
    }

    public ContactUsPage getContactUsPage() {
        click("writeToUsBtn_XPATH");
        return new ContactUsPage();
    }

    public LiveChatPage getLiveChatPage() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(OR.getProperty("startChatBtn_CSS")))).build().perform();
        Thread.sleep(2000);
        click("startChatBtn_CSS");
        return new LiveChatPage();
    }

    public DiscoverEurosportPage getDoscovetEurosportPage() {
        click("discoverEurosport_XPATH");
        return new DiscoverEurosportPage();
    }

    public SettingsAndDevicesPage getSettingsAndDevicesPage() {
        click("settingAndDevices_CSS");
        return new SettingsAndDevicesPage();
    }

    public PassInformationPage getPassInformationPage() {
        click("passInformation_CSS");
        return new PassInformationPage();
    }

    public ManageAccountPage getManageAccountPage() {
        click("mainAccount_CSS");
        return new ManageAccountPage();
    }

    public PaymentsAndBillingPage getPaymentsAndBillingPage() {
        click("paymentsAndBilling_CSS");
        return new PaymentsAndBillingPage();
    }

    public ResolveIssuesPage getResolveIssuesPage() {
        click("resolveIssues_CSS");
        return new ResolveIssuesPage();
    }
}
