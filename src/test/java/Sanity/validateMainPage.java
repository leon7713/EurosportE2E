package Sanity;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.MainPage;
import pageObject.SideMenuPage;
import resources.base;

import java.io.IOException;

public class validateMainPage extends base {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initialiseDriver();
    }

    @Test (dataProvider = "getData")
    public void validateTitle(String catListNumb) throws InterruptedException {
        driver.get(prop.getProperty("url"));
        MainPage mp = new MainPage(driver);
        SideMenuPage smp = new SideMenuPage(driver);

        mp.getMainLogo().isDisplayed();
        int x = mp.getCategoryListNumber();
        Assert.assertTrue(catListNumb.equals(Integer.toString(x)));
        mp.getMoreBtn().click();

        smp.getEurosportLogo().isDisplayed();

        Thread.sleep(1000);
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
    Object[][] data = new Object[1][1];
    data[0][0] = "10";

    return data;
    }
}
