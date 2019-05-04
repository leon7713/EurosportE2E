package testcases;

import base.Page;
import base.SideMenuPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.conditionsAndPolicyPages.CookiePolicyPage;

import java.io.IOException;

public class validateCookiePolicyPageTest extends Page{

    public static Logger log = LogManager.getLogger(Page.class.getName());

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test (dataProvider = "DataProvider_5")
    public void CookiePolicyPageTest(String wordsNumb) throws InterruptedException{
        MainPage mp = new MainPage();
        SideMenuPage smp = mp.clickOnHamburgerBtn();
        Thread.sleep(1000);
        CookiePolicyPage cpp = smp.getCookiePolicyPage();
        cpp.verifyMainTitle();
        cpp.verifyMainTextWordsCount(wordsNumb);

        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }
}
