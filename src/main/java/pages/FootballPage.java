package pages;

import base.Page;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FootballPage extends Page {

    public void getFootballLogo() {
        isElementDisplayed("footballLogo_LT");
    }

    public PremierLeaguePage getPremierLeagueBtn() {
        click("premierLeagueBtn_XPATH");
        return new PremierLeaguePage();
    }

    public void verifyMainCatVisibility() {
        boolean result = true;
        int catNumb = Integer.parseInt(OR.getProperty("footballPageMainCatNumb"));

        for (int i = 1; i <= catNumb; i++) {
            if (!driver.findElement(By.xpath("//*[@class = \"categorylist\"]/li[" + i + "]")).isDisplayed()) {
                result = false;
            }
        }
        Assert.assertTrue(result);
    }
}
