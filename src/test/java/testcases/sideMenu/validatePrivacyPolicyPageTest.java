package testcases.sideMenu;

import base.Page;
import base.SideMenuPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.conditionsAndPolicyPages.PrivacyPolicyPage;

import java.io.IOException;

public class validatePrivacyPolicyPageTest extends Page {

    public static Logger log = LogManager.getLogger(Page.class.getName());

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test (dataProvider = "DataProvider_3")
    public void validatePrivacyPolicyPageTest(String ActWordNumb) throws InterruptedException {
        MainPage mp = new MainPage();
        SideMenuPage smp = mp.clickOnHamburgerBtn();
        Thread.sleep(1000);
        PrivacyPolicyPage ppp = smp.getPrivacyPolicyPage();
        ppp.verifyMainTitle();
        ppp.verifyWordsCount(ActWordNumb);

        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }
}
