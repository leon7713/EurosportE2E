package testcases;

import base.Page;
import base.SideMenuPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.conditionsAndPolicyPages.PrivacySettingsPage;

import java.io.IOException;

public class validatePrivacySettingsPageTest extends Page{

    public static Logger log = LogManager.getLogger(Page.class.getName());

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test (dataProvider = "DataProvider_4")
    public void validatePrivacySettingsPageTest(String vendorsNumb) throws InterruptedException {
        MainPage mp = new MainPage();
        SideMenuPage smp = mp.clickOnHamburgerBtn();
        Thread.sleep(1000);
        PrivacySettingsPage psp = smp.getPrivacySettingsPage();
        psp.validateMainTitle();
        psp.measurement_On_Off();
        psp.verifyVendorsNumber(vendorsNumb);

        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }
}
