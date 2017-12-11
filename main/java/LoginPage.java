import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Asus on 24.11.2017.
 */
public class LoginPage extends AbstractPage {

    private final Logger Logger = LogManager.getLogger(LoginPage.class);

    private final String URL = "https://twitter.com/?lang=ru";

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(id="signin-email")
    private WebElement email;

    @FindBy(id="signin-password")
    private WebElement password;

    @FindBy(className="flex-table-secondary")
    private WebElement loginButton;

    @Override
    public void open()
    {
        driver.navigate().to(URL);
        Logger.info("Login page opened");
    }

    public void login(String email, String password){
        this.email.clear();
        this.email.sendKeys(email);

        this.password.clear();
        this.password.sendKeys(password);

        loginButton.click();
    }


    public MainPage loginSuccess(String email, String password) {
        login(email, password);
        return new MainPage(driver);
    }
    public ErrorLoginPage loginFailed(String email, String password) {
        login(email, password);
        return new ErrorLoginPage(driver);
    }
}
