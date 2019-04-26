package pages;

import base.Page;
import org.openqa.selenium.By;

import java.util.Random;

public class PremierLeaguePage extends Page {

    public void getPremierLeagueLogo() {
        isElementDisplayed("premierLeagueLogo_XPATH");
    }

    public void verifyCatNumb(String catNumb) {
        int catNumbers = Integer.parseInt(catNumb);

        for (int i = 1; i <= catNumbers; i++) {
            driver.findElement(By.xpath("//*[@class = \"categorylist\"]/li[" + i + "]")).isDisplayed();
        }
    }


    public void getRandomCategory() {
        Random r = new Random();
        int rand = r.nextInt((5 - 1) + 1) + 1; //random from 1 to 5 --- (max - min + 1) + min

        driver.findElement(By.xpath("//*[@class = \"categorylist\"]/li[" + rand + "]")).click();
    }
}
