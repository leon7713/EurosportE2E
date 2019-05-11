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
import pages.mainSideMenuPages.underHelpPagePages.ContactUsPage;

import java.io.IOException;

public class validateContactUsPageTest {

    public static Logger log = LogManager.getLogger(Page.class.getName());

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test
    public void contactUsPageTest() throws InterruptedException{
        MainPage mp = new MainPage();
        SideMenuPage smp = mp.clickOnHamburgerBtn();
        Thread.sleep(2000);
        HelpPage hp = smp.getHelpPage();
        ContactUsPage cup = hp.getContactUsPage();
        cup.validateMainTitle();

        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }
}
