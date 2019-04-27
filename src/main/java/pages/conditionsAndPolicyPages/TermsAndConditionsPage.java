package pages.conditionsAndPolicyPages;

import base.Page;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TermsAndConditionsPage extends Page {

    public void verifyLegalNoticeTitle() {
        isElementDisplayed("legalNotice_CSS");
    }

    public void verifyNumbWordsInText(String numbWords) {
        String text = driver.findElement(By.xpath(OR.getProperty("text_XPATH"))).getText();
        String[] wordsCount = text.split("[^A-Za-z]");
        int wordsCountNumber = wordsCount.length;
        Assert.assertEquals(wordsCountNumber, Integer.parseInt(numbWords));
    }

    public void verifyCommentsLabel() {
        isElementDisplayed("commentsLabel_CSS");
    }

}
