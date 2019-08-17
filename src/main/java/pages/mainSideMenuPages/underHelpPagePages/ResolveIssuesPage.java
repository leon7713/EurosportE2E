package pages.mainSideMenuPages.underHelpPagePages;

import base.Page;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Random;

public class ResolveIssuesPage extends Page {

    public void verifyResolveIssuesPageTest() {

        int titleCount = driver.findElements(By.cssSelector(".section-tree-title")).size();
        Assert.assertEquals(titleCount, Integer.parseInt(OR.getProperty("titlesCount")));

        Random random = new Random();
        Random random1 = new Random();
        int rand = random.nextInt(4) + 1; //from 1 to 4 included for main titles

        String textExpected = null;
        String textActual = null;

        switch (rand) {
            case 1:
                int rand1 = random1.nextInt(5) + 1;
                textExpected = driver.findElement(By.xpath("//div//section[" + rand + "]//li[" +rand1 + "]//a")).getText();
                driver.findElement(By.xpath("//div//section[" + rand + "]//li[" +rand1 + "]//a")).click();
                textActual = driver.findElement(By.cssSelector(".article-title")).getText();
                break;
            case 2:
                int rand2 = 1;
                textExpected = driver.findElement(By.xpath("//div//section[" + rand + "]//li[" +rand2 + "]//a")).getText();
                driver.findElement(By.xpath("//div//section[" + rand + "]//li[" +rand2 + "]//a")).click();
                textActual = driver.findElement(By.cssSelector(".article-title")).getText();
                break;
            case 3:
            case 4:
                int rand3 = random1.nextInt(3) + 1;
                textExpected = driver.findElement(By.xpath("//div//section[" + rand + "]//li[" +rand3 + "]//a")).getText();
                driver.findElement(By.xpath("//div//section[" + rand + "]//li[" +rand3 + "]//a")).click();
                textActual = driver.findElement(By.cssSelector(".article-title")).getText();
                break;
        }

        Assert.assertEquals(textActual, textExpected);
    }
}
