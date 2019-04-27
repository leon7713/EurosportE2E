package testcases;

import base.Page;
import base.SideMenuPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.conditionsAndPolicyPages.TermsAndConditionsPage;

import java.io.IOException;

public class validateTermsAndConditionsPageTest extends Page{

    public static Logger log = LogManager.getLogger(Page.class.getName());

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test (dataProvider = "DataProvider_2")
    public void validateTermsAndCondPageTest(String ActWordsNumb) throws InterruptedException {
        MainPage mp = new MainPage();
        SideMenuPage smp = mp.clickOnHamburgerBtn();
        Thread.sleep(1000);
        TermsAndConditionsPage tcp = smp.getTermsAndConditionsPage();
        tcp.verifyLegalNoticeTitle();
        tcp.verifyNumbWordsInText(ActWordsNumb);
        tcp.verifyCommentsLabel();

        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }
}
