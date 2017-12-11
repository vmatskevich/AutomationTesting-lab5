import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vika on 11.12.2017.
 */
public class MainPage extends AbstractPage{
    private final String URL = "https://twitter.com/";


    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(className = "u-linkComplex-target")
    private WebElement userName;

    @FindBy(className = "stream")
    private WebElement posts;

    @FindBy(className = "js-nav js-tooltip js-dynamic-tooltip")
    private WebElement homeButton;

    public String getUserName() {
        return userName.getAttribute("content");
    }

    public boolean postsAreDisplayed() {
        return posts.isDisplayed();
    }

    public MainPage clickOnHomeButton()
    {
        MainPage mainPage= new MainPage(driver);
        homeButton.click();
        return mainPage;
    }


    @Override
    public void open()
    {
        driver.navigate().to(URL);
    }
}
