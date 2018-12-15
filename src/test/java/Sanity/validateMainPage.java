package Sanity;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.MainPage;
import resources.base;

import java.io.IOException;

public class validateMainPage extends base {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initialiseDriver();
    }

    @Test
    public void validateTitle() {
        driver.get(prop.getProperty("url"));
        MainPage mp = new MainPage(driver);

        mp.getMainLogo().isDisplayed();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver=null;
    }
}
