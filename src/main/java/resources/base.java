package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class base {

    public static WebDriver driver;
    public Properties prop;

    public WebDriver initialiseDriver() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Leonidus\\projects\\EurosportE2E\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);
        String url = prop.getProperty("url");
        System.out.println(url);

        if (browserName.equals("firefox")) {
            //execute in Firefox driver
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Leonidus\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (browserName.equals("chrome")) {
            //execute in chrome driver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Leonidus\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserName.equals("IE")) {
            //execute in chrome driver
            System.setProperty("webdriver.IE.driver", "C:\\Users\\Leonidus\\IdeaProjects\\testselenium\\drivers\\MicrosoftWebDriver.exe");
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        return driver;
    }

    public void getScreenshot(String result) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C://test//" + result + "screenshot.png"));
    }

}
