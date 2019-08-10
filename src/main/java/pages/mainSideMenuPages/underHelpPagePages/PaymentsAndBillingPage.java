package pages.mainSideMenuPages.underHelpPagePages;

import base.Page;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.*;

public class PaymentsAndBillingPage extends Page {

    public void verifyPaymentsAndBillingsPageTest() {

        isElementDisplayed("main_title_PBP_XPATH");
        int titlesCount = driver.findElements(By.cssSelector(".section-tree-title")).size();
        Assert.assertEquals(titlesCount, Integer.parseInt(OR.getProperty("expectedTitlesCount")));

        String[] titlesArray = new String[titlesCount];

        for (int i = 1; i <= titlesCount; i++) {
            String text = driver.findElement(By.xpath("//*[@class = \"sections-list\"]//section[" + i + "]//h3")).getText();
            titlesArray[i - 1] = text;
        }

        Map<Integer, String> map = new HashMap<Integer, String>();

        for (int i = 0; i < titlesArray.length; i++) {
            map.put(i, titlesArray[i]);
        }

        List<String> titlesList = new ArrayList<String>();

        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            titlesList.add(pair.getValue());
        }

        boolean firstVerification = false;

        for (int i = 1; i <= titlesCount; i++) {
            String text = driver.findElement(By.xpath("//*[@class = \"sections-list\"]//section[" + i + "]//h3")).getText();
            System.out.println(titlesList.get(i - 1));
            System.out.println(text);
            if (!text.equals(titlesList.get(i - 1))) {
                firstVerification = true;
                break;
            }
        }

        Assert.assertFalse(firstVerification);

        int subTitlesCount = driver.findElements(By.cssSelector(".article-link")).size();
        Assert.assertEquals(subTitlesCount, Integer.parseInt(OR.getProperty("expectedSubTitlesCount")));
    }
}
