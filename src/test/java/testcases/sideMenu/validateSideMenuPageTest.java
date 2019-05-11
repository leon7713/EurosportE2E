package testcases.sideMenu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import base.SideMenuPage;
import base.Page;

import java.io.IOException;

public class validateSideMenuPageTest {

    public static Logger log = LogManager.getLogger(Page.class.getName());

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test
    public void sideMenuTests() throws InterruptedException {
        MainPage mp = new MainPage();

        SideMenuPage smp = mp.getMoreBtn();

        smp.getEurosportLogo();
        log.info("Eurosport logo is displaying");
        smp.verifySideMenuCategories();
        smp.verifyAboutUsCat();

        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }

}
