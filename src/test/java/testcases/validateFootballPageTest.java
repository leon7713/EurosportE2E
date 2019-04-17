package testcases;

import base.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "getData")
    public void basicTests(String mainCatNumb) throws IOException, InterruptedException {
        MainPage mp = new MainPage();
        FootballPage fp = new FootballPage();

        mp.getFootballBtn().click();
        Assert.assertTrue(fp.getFootballLogo().isDisplayed());
        log.info("Football Logo is displaying");

        Assert.assertTrue(fp.verifyMainCatVisibility(Integer.parseInt(mainCatNumb)));

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
        data[0][0] = "9"; //main categories number, only visible!

        return data;
    }
}
