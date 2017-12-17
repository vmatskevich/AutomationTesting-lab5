package driver;

import listener.Listener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getRootLogger();

    private static EventFiringWebDriver eventDriver;
    private static Listener listener;

    public static WebDriver getDriver(){
        if (eventDriver == null){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

            driver = new ChromeDriver();
            eventDriver = new EventFiringWebDriver(driver);
            listener = new Listener();
            eventDriver.register(listener);
            eventDriver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            logger.info("Started Google Chrome Browser.");
        }

        return eventDriver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

}