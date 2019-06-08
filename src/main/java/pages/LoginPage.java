package pages;

import base.Page;

public class LoginPage extends Page {

    public void login() throws InterruptedException {
        isElementDisplayed("loginMainTitle_XPATH");
        type("emailFeild_CSS", OR.getProperty("emailData"));
        type("passwordField_CSS", OR.getProperty("passwordData"));
        //Thread.sleep(1000);
        //click("loginBtn_CSS");
    }
}
