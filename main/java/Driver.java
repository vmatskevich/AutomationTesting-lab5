import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getRootLogger();

    public static WebDriver getDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            logger.info("Started Google Chrome Browser.");
        }

        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }


    public static Long getPosition() {
        if (driver != null) {
            logger.debug("[getPosition] receiving position");
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            return (Long) executor.executeScript("return window.pageYOffset;");
        }

        return null;
    }

    public static void scroll(int value) {
        if (driver != null) {
            logger.debug("[scroll] scrolling page");
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0, " + value + ")", "");
        }
    }
}