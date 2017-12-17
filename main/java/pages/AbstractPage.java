package pages;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Asus on 26.11.2017.
 */
public abstract class AbstractPage {
    protected static WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract void open();

    public void initDriver(){
        driver = Driver.getDriver();
    }

    public void closeDriver(){
        Driver.closeDriver();
    }
}
