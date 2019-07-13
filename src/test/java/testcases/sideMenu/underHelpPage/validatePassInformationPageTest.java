package testcases.sideMenu.underHelpPage;

import base.Page;
import base.SideMenuPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.mainSideMenuPages.HelpPage;
import pages.mainSideMenuPages.underHelpPagePages.PassInformationPage;

import java.io.IOException;

public class validatePassInformationPageTest extends Page {

    @BeforeTest
    public void setUp() throws IOException {
        initConfiguration();
    }

    @Test
    public void PassInformationPageTest() throws InterruptedException {
        MainPage mp = new MainPage();
        SideMenuPage smp = mp.clickOnHamburgerBtn();
        Thread.sleep(2000);
        HelpPage hp = smp.getHelpPage();
        PassInformationPage pip = hp.getPassInformationPage();
        pip.verifyPassInformationPageTest();

        Thread.sleep(2000);
    }


    @AfterTest
    public void tearDown() {
        quitBrowser();
    }
}
