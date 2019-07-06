package testcases.sideMenu.underHelpPage;

import base.Page;
import base.SideMenuPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.mainSideMenuPages.HelpPage;
import pages.mainSideMenuPages.underHelpPagePages.SettingsAndDevicesPage;

import java.io.IOException;

public class validateSettingAndDevicesPageTest extends Page{

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test (dataProvider = "DataProvider_6")
    public void settingAndDevicesPageTest(String catAmount) throws InterruptedException {
        MainPage mp = new MainPage();
        SideMenuPage smp = mp.clickOnHamburgerBtn();
        Thread.sleep(2000);
        HelpPage hp = smp.getHelpPage();
        SettingsAndDevicesPage sdp = hp.getSettingsAndDevicesPage();
        sdp.verifyHowToWatchAndStreamPage(catAmount);
        sdp.verifyTechnicalRequirementsSection();
        sdp.verifyPlayerSettingsSection();
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }
}
