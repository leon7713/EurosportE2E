package pages.mainSideMenuPages.underHelpPagePages;

import base.Page;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PassInformationPage extends Page {

    public void verifyPassInformationPageTest() {
        isElementDisplayed("main_title_PIP_XPATH");
        int sectionsCount = driver.findElements(By.cssSelector(".section-tree-title")).size();
        List<String> list = new ArrayList<String>();

        for (int i = 1; i <= sectionsCount; i++) {
            list.add(driver.findElement(By.xpath("//*[@class = \"sections-list\"]//section[" + i + "]//h3")).getText());
        }

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        for (int i = 0; i < list.size(); i++) {
            map.put(i + 1, list.get(i));
        }

        Assert.assertEquals(map.size(), Integer.parseInt(OR.getProperty("countriesNumber")));

        

//        for (Map.Entry<Integer, String> pair : map.entrySet()) {
//            try {
//                FileWriter fw = new FileWriter("C:\\test\\PassInformationTest.txt", true);
//                fw.write(pair + "\n");
//                fw.close();
//            } catch (IOException e) {
//                System.err.println("Problem writing to the file statsTest.txt");
//            }
//        }
    }
}
