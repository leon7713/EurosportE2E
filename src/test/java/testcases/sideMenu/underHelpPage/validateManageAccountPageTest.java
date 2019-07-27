package testcases.sideMenu.underHelpPage;

import base.Page;
import base.SideMenuPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.mainSideMenuPages.HelpPage;
import pages.mainSideMenuPages.underHelpPagePages.ManageAccountPage;

import java.io.IOException;

public class validateManageAccountPageTest extends Page {

    @BeforeTest
    public void setUp() throws IOException {
        initConfiguration();
    }


    @Test
    public void ManageAccountPageTest() throws InterruptedException {
        MainPage mp = new MainPage();
        SideMenuPage smp = mp.clickOnHamburgerBtn();
        Thread.sleep(2000);
        HelpPage hp = smp.getHelpPage();
        ManageAccountPage map = hp.getManageAccountPage();
        map.verifyManageAccountPageTest();

        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown() {
        quitBrowser();
    }
}
