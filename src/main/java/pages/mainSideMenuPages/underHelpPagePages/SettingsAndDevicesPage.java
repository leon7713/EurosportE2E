package pages.mainSideMenuPages.underHelpPagePages;

import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;

public class SettingsAndDevicesPage extends Page {

    public void verifyHowToWatchAndStreamPage(String catAmount) {
        isElementDisplayed("mainTitleSDP_CSS");
        Actions actions = new Actions(driver);
        WebElement seeAllArticles = driver.findElement(By.cssSelector(OR.getProperty("seeAllArticles_CSS")));
        actions.moveToElement(seeAllArticles).build().perform();
        click("seeAllArticles_CSS");
        int articlesAmount = driver.findElements(By.cssSelector(".article-list-item")).size();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 1; i <= articlesAmount; i++) {
            String str = driver.findElement(By.xpath("//*[@class = \"article-list article-count-11\"]/*[" + i + "]")).getText();
            list.add(str);
        }
        Assert.assertEquals(list.size(), Integer.parseInt(catAmount));
        driver.navigate().back();
    }

    public void verifyTechnicalRequirementsSection() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        int catNumb = driver.findElements(By.xpath("//*[@class = \"article-list article-count-4\"]//li")).size();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@class = \"article-list article-count-4\"]//li[4]"));
        actions.moveToElement(element).build().perform();
        for (int i = 1; i <= catNumb; i++) {
            String str = driver.findElement(By.xpath("//*[@class = \"article-list article-count-4\"]//li[" + i + "]")).getText();
            map.put(i , str);
        }
        Assert.assertEquals(map.size(), Integer.parseInt(OR.getProperty("TechnicalRequirementsCatNumb")));
    }

    public void verifyPlayerSettingsSection() {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@class = \"article-list article-count-1\"]//li[1]"));
        actions.moveToElement(element).build().perform();
        int fieldCount = driver.findElements(By.xpath("//*[@class = \"article-list article-count-1\"]//li")).size();
        Assert.assertEquals(fieldCount, Integer.parseInt(OR.getProperty("PlayerSettingsCatNumb")));
    }
}
