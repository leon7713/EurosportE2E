package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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

    @Test (dataProvider = "getData")
    public void verifyCatNumber(String catListNumb) throws InterruptedException, IOException {
        MainPage mp = new MainPage();

        mp.getMainLogo().isDisplayed();
        Assert.assertEquals(Integer.toString(mp.getCategoryListNumber()), catListNumb);
        log.info("Test - validate main page - is successful");
        Thread.sleep(1000);

    }

    @Test
    public void verifyLegalNotices () throws InterruptedException, IOException {
        MainPage mp = new MainPage();

        mp.scrolltoLegalNotice();
        mp.getLegalNotices().isDisplayed();
        mp.getPrivacyPolicy().isDisplayed();
        Assert.assertTrue(mp.getCookiePolicy().isDisplayed());

        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }

    @DataProvider
    public Object[][] getData() {
        //row stands for how many different data types test should run
        //column stands for how many values per each test
    Object[][] data = new Object[1][1];
    data[0][0] = "10"; //main categories number

    return data;
    }
}
