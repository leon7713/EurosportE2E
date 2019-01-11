package Sanity;

import myresources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.FootballPage;
import pageObject.MainPage;

import java.io.IOException;

public class validateFootballPageTest extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initialiseDriver();
        log.info("Driver is initialised");
    }

    @Test(dataProvider = "getData")
    public void basicTests(String mainCatNumb) throws InterruptedException {
        driver.get(prop.getProperty("url"));
        MainPage mp = new MainPage(driver);
        FootballPage fp = new FootballPage(driver);

        mp.getFootballBtn().click();
        Assert.assertTrue(fp.getFootballLogo().isDisplayed());
        log.info("Football Logo is displaying");

        Assert.assertTrue(fp.verifyMainCatVisibility(Integer.parseInt(mainCatNumb)));

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
        data[0][0] = "9"; //main categories number, only visible!

        return data;
    }
}
