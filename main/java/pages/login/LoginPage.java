package pages.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;


/**
 * Created by Asus on 24.11.2017.
 */
public class LoginPage extends AbstractPage {
    private final Logger Logger = LogManager.getLogger(LoginPage.class);
    private final String URL = "https://twitter.com/login";

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(id="signin-email")
    private WebElement email;

    @FindBy(id="signin-password")
    private WebElement password;

    @FindBy(className="flex-table-secondary")
    private WebElement loginButton;

    @FindBy(className = "message-text")
    private WebElement errorMassage;

    @Override
    public void open()
    {
        AbstractPage.driver.navigate().to(URL);
        Logger.info("Login page opened");
    }

    public void login(String email, String password){
        this.email.clear();
        this.email.sendKeys(email);

        this.password.clear();
        this.password.sendKeys(password);

        loginButton.click();
        Logger.info("Sign in performed");
    }

    public boolean massageIsDisplayed() {

        return errorMassage.isDisplayed();
    }

}
