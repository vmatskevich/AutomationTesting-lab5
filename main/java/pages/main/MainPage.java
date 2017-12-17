package pages.main;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.AbstractPage;

/**
 * Created by Vika on 11.12.2017.
 */
public class MainPage extends AbstractPage {
    private final String URL = "https://twitter.com/";
    private final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(MainPage.class);

    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(className = "username u-dir")
    private WebElement userName;

    @FindBy(className = "stream")
    private WebElement posts;

    @FindBy(id = "global-nav-home")
    private WebElement homeButton;

    public String getUserName() {
        return userName.getAttribute("content");
    }

    public boolean postsAreDisplayed() {
        return posts.isDisplayed();
    }

    public MainPage clickOnHomeButton()
    {
        MainPage mainPage= new MainPage(AbstractPage.driver);
        homeButton.click();
        return mainPage;
    }


    @Override
    public void open()
    {
        AbstractPage.driver.navigate().to(URL);
        Logger.info("Main page opened");
    }
}
