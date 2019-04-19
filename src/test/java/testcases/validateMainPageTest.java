package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import base.Page;

import java.io.IOException;

public class validateMainPageTest {

    public static Logger log = LogManager.getLogger(Page.class.getName());

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test
    public void verifyCatNumber() throws InterruptedException {
        MainPage mp = new MainPage();

        mp.getMainLogo();
        mp.verifyCategoryListNumber();
        log.info("Test - validate main page - is successful");
        Thread.sleep(1000);
    }

    @Test
    public void verifyLegalNotices () throws InterruptedException {
        MainPage mp = new MainPage();

        mp.scrolltoLegalNotice();
        mp.getLegalNotices();
        mp.getPrivacyPolicy();
        mp.getCookiePolicy();

        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }

}
