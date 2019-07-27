package pages.mainSideMenuPages.underHelpPagePages;

import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ManageAccountPage extends Page {

    public void verifyManageAccountPageTest() throws InterruptedException {
        isElementDisplayed("main_title_MAP_XPATH");
        int accountCatNumb = driver.findElements(By.className("article-link")).size();
        String[] arr = new String[accountCatNumb];

        for (int i = 1; i <= arr.length; i++) {
            arr[i - 1] = driver.findElement(By.xpath("//*[@class = \"sections-list\"]//li[" + i + "]")).getText();
        }

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        Map<Integer, String> map = new HashMap<Integer, String>();

        for (int i = 0; i < list.size(); i++) {
            map.put(i + 1, list.get(i));
        }

        Assert.assertEquals(map.size(), Integer.parseInt(OR.getProperty("catNumber")));
        Thread.sleep(2000);

        Random random = new Random();
        int rnd = random.nextInt((6 - 1) + 1) + 1; //from 1 to 6 included

        WebElement element;
        element = driver.findElement(By.cssSelector("main li:nth-child(" + rnd + ") > a"));
        element.click();
        Thread.sleep(2000);

        String pageTitle = driver.findElement(By.xpath("//*[@class = \"article-header\"]//h1")).getText();
        boolean result = false;

        for (String str : list) {
            if (str.equals(pageTitle)) result = true;
        }

        Assert.assertTrue(result);
    }
}
