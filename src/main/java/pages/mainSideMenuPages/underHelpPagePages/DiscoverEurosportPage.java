package pages.mainSideMenuPages.underHelpPagePages;

import base.Page;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.HashSet;
import java.util.Set;

public class DiscoverEurosportPage extends Page {

    public void verifyDoscoverEurosportPage() {
        isElementDisplayed("mainTitleDEP_CSS");
        click("seeAllCategoriesBtn_CSS");
        Set<String> set = new HashSet<String>();
        for (int i = 1; i <= Integer.parseInt(OR.getProperty("numberOfCategories")); i++) {
            set.add(driver.findElement(By.xpath("//*[@class = \"article-list article-count-7\"]/li[" + i + "]")).getText());
        }
        Assert.assertEquals(set.size(), Integer.parseInt(OR.getProperty("numberOfCategories")));
    }
}
