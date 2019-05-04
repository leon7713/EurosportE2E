package pages.conditionsAndPolicyPages;

import base.Page;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.LinkedList;

public class CookiePolicyPage extends Page {

    public void verifyMainTitle() {
        isElementDisplayed("mainTitleCPP_CSS");
    }

    public void verifyMainTextWordsCount(String wordsCount) {
        String mainText = driver.findElement(By.cssSelector(OR.getProperty("mainText_CSS"))).getText();
        String[] arr = mainText.split(" ");
        LinkedList arrList = new LinkedList();

        for (String word:arr) {
            arrList.add(word);
        }

        Assert.assertEquals(arrList.size(), Integer.parseInt(wordsCount));
    }
}
