package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SideMenuPage;
import base.Page;

import java.io.IOException;

public class validateSideMenuPage extends Page {

    public validateSideMenuPage() throws IOException {}

    public static Logger log = LogManager.getLogger(Page.class.getName());


    @Test (dataProvider = "getData")
    public void basicTests(String sideMenuCatNumb, String AboutUsCatNumb) throws InterruptedException, IOException {
        MainPage mp = new MainPage();
        SideMenuPage smp = new SideMenuPage();

        mp.getMoreBtn().click();

        smp.getEurosportLogo().isDisplayed();
        log.info("Eurosport logo is displaying");
        Assert.assertEquals(Integer.toString(smp.getSideMenuCategories()), sideMenuCatNumb);

        Assert.assertEquals(Integer.toString(smp.getAboutUsCat()), AboutUsCatNumb);

        Thread.sleep(1000);
        //quit();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver=null;
    }

    @DataProvider
    public Object[][] getData() {
        //row stands for how many different data types test should run
        //column stands for how many values per each test
        Object[][] data = new Object[1][2];
        data[0][0] = "9"; // side menu categories number, one category is hidden, the "favorites" category
        data[0][1] = "6"; // about Us categories number

        return data;
    }
}
