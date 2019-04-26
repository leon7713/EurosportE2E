package testcases;

import base.Page;
import base.SideMenuPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.conditionsAndPolicyPages.TermsAndConditionsPage;

import java.io.IOException;

public class validateTermsAndConditionsPageTest {

    public static Logger log = LogManager.getLogger(Page.class.getName());

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test
    public void validateTermsAndCondPageTest() throws InterruptedException {
        MainPage mp = new MainPage();
        SideMenuPage smp = mp.clickOnHamburgerBtn();
        Thread.sleep(1000);
        TermsAndConditionsPage tcp = smp.getTermsAndConditionsPage();
        tcp.verifyLegalNoticeTitle();

        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }
}
