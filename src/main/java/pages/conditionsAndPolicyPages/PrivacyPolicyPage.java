package pages.conditionsAndPolicyPages;

import base.Page;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

public class PrivacyPolicyPage extends Page {

    public void verifyMainTitle() {
        isElementDisplayed("mainTitle_CSS");
    }

    public void verifyWordsCount(String ActWordNumb) {
        String text = driver.findElement(By.cssSelector(OR.getProperty("text_CSS"))).getText();
        String[] wordNumb = text.split("[^A-Za-z]");
        List<String> wordNumbList = new LinkedList<String>();

        for (String word:wordNumb) {
            wordNumbList.add(word);
        }

        Assert.assertEquals(wordNumbList.size(), Integer.parseInt(ActWordNumb));
    }
}
