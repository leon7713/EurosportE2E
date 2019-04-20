package testcases;

import base.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FootballPage;
import pages.MainPage;

import java.io.IOException;

public class validateFootballPageTest {

    public static Logger log = LogManager.getLogger(Page.class.getName());

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test
    public void footballPageTests() throws IOException, InterruptedException {
        MainPage mp = new MainPage();

        FootballPage fp = mp.getFootballBtn();
        fp.getFootballLogo();
        log.info("Football Logo is displaying");

        fp.verifyMainCatVisibility();

        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }

}
