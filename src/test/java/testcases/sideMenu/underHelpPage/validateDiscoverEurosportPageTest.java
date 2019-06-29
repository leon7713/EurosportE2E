package testcases.sideMenu.underHelpPage;

import base.Page;
import base.SideMenuPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.mainSideMenuPages.HelpPage;
import pages.mainSideMenuPages.underHelpPagePages.DiscoverEurosportPage;

import java.io.IOException;

public class validateDiscoverEurosportPageTest {

    public static Logger log = LogManager.getLogger(Page.class.getName());

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test
    public void discoverEurosportPageTest() throws InterruptedException {
        MainPage mp = new MainPage();
        SideMenuPage smp = mp.clickOnHamburgerBtn();
        Thread.sleep(1000);
        HelpPage hp = smp.getHelpPage();
        Thread.sleep(1000);
        DiscoverEurosportPage dep = hp.getDoscovetEurosportPage();
        dep.verifyDoscoverEurosportPage();

        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }
 }
