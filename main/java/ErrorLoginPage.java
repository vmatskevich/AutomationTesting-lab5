
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vika on 10.12.2017.
 */
public class ErrorLoginPage extends AbstractPage {
    private final String URL = "https://twitter.com/login/error?username_or_email=vimtskch&redirect_after_login=%2F%3Flang%3Dru";

    public ErrorLoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(className = "message-text")
    private WebElement errorMassage;


    public boolean massageAreDisplayed() {
        return errorMassage.isDisplayed();
    }

    @Override
    public void open()
    {
        AbstractPage.driver.navigate().to(URL);
    }
}
