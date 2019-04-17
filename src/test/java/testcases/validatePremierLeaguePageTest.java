package testcases;

import base.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FootballPage;
import pages.MainPage;
import pages.PremierLeaguePage;

import java.io.IOException;

public class validatePremierLeaguePageTest {


    public static Logger log = LogManager.getLogger(Page.class.getName());

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test (dataProvider = "getData")
    public void randomTests(String mainCatNumb) throws InterruptedException, IOException {
        MainPage mp = new MainPage();
        FootballPage fp = new FootballPage();
        PremierLeaguePage plp = new PremierLeaguePage();

        mp.getFootballBtn().click();
        fp.getPremierLeagueBtn().click();

        plp.getPremierLeagueLogo().isDisplayed();
        plp.verifyCatNumb(Integer.parseInt(mainCatNumb));
        plp.getRandomCategory().click();
        log.info("test - random tests - is done successfully");

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
        data[0][0] = "5"; //main categories number

        return data;
    }
}
