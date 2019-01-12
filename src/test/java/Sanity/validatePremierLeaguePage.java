package Sanity;

import myresources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.FootballPage;
import pageObject.MainPage;
import pageObject.PremierLeaguePage;

import java.io.IOException;
import java.util.Random;

public class validatePremierLeaguePage extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initialiseDriver();
        log.info("Driver is initialised");
    }

    @Test (dataProvider = "getData")
    public void randomTests(String mainCatNumb) throws InterruptedException {
        driver.get(prop.getProperty("url"));
        MainPage mp = new MainPage(driver);
        FootballPage fp = new FootballPage(driver);
        PremierLeaguePage plp = new PremierLeaguePage(driver);

        mp.getFootballBtn().click();
        fp.getPremierLeagueBtn().click();

        plp.getPremierLeagueLogo().isDisplayed();
        plp.verifyCatNumb(Integer.parseInt(mainCatNumb));
        plp.getRandomCategory().click();

        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
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
