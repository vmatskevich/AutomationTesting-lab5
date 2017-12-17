package pages.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import pages.login.LoginPage;

/**
 * Created by Vika on 10.12.2017.
 */
public class UserPage extends AbstractPage {

    private final Logger Logger = LogManager.getLogger(LoginPage.class);
    private final String URL = "https://twitter.com/vimtskch";
    public UserPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void open()
    {
        AbstractPage.driver.navigate().to(URL);
        Logger.info("Login page opened");
    }

    @FindBy(className = "u-linkComplex-target")
    private WebElement userName;

    @FindBy(className = "topbar-tweet-btn")
    private WebElement modalWindow;

    @FindBy(className = "global-tweet-dialog-dialog")
    private WebElement tweetButton;

    @FindBy(className = "tweet-action EdgeButton EdgeButton--primary js-tweet-btn")
    private WebElement tweetButtonInModalWindow;

    @FindBy(className = "message-inside")
    private WebElement massageAboutPublication;
    @FindBy(className = "ProfileNav-item--favorites")
    private WebElement buttonToFavourite;
    @FindBy(className = "SearchNavigation-titleText")
    private WebElement searchNavigation;


    public boolean isThisUserPage()
    {
        return userName.isDisplayed();
    }
    public boolean getSearchResult()
    {
        return searchNavigation.isDisplayed();
    }


    public boolean createNewTweet() {
        tweetButton.click();
        modalWindow.isDisplayed();
        tweetButtonInModalWindow.click();
        return massageAboutPublication.isDisplayed();
    }

    public UserPage goToFavouritePosts(){
        buttonToFavourite.click();
        return new UserPage(AbstractPage.driver);
    }

    public void searchInTwi(){
        WebElement search = driver.findElement(By.className("search-input"));
        search.sendKeys("Hello");
        search.submit();
        Logger.info("Detected!");
    }


}
