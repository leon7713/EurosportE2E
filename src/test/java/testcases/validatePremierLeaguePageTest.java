package testcases;

import base.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FootballPage;
import pages.MainPage;
import pages.PremierLeaguePage;

import java.io.IOException;

public class validatePremierLeaguePageTest extends Page{

    public static Logger log = LogManager.getLogger(Page.class.getName());

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test (dataProvider = "getData")
    public void PremierLeagueTests(String mainCatNumb) throws InterruptedException, IOException {
        MainPage mp = new MainPage();

        FootballPage fp = mp.getFootballBtn();
        PremierLeaguePage plp = fp.getPremierLeagueBtn();

        plp.getPremierLeagueLogo();
        plp.verifyCatNumb(mainCatNumb);
        plp.getRandomCategory();
        log.info("test - random tests - is done successfully");

        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }

}
