package testcases;

import base.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

import java.io.IOException;

public class loginPageTest {

    public static Logger log = LogManager.getLogger(Page.class.getName());

    @BeforeTest
    public void setUp() throws IOException {
        Page.initConfiguration();
    }

    @Test
    public void loginTest() throws InterruptedException {
        MainPage mp = new MainPage();
        LoginPage lp = mp.getLoginPage();
        lp.login();

        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown() {
        Page.quitBrowser();
    }
}
