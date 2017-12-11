import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Vika on 10.12.2017.
 */
public class UserPage extends AbstractPage {

    private final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(LoginPage.class);
    private final String URL = "https://twitter.com/vimtskch";
    public UserPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void open()
    {
        driver.navigate().to(URL);
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


    public boolean isThisUserPage()
    {
        return userName.isDisplayed();
    }


    public boolean createNewTweet() {
        UserPage userPage = new UserPage(driver);

        tweetButton.click();
        modalWindow.isDisplayed();
        tweetButtonInModalWindow.click();
        return massageAboutPublication.isDisplayed();
    }

}
