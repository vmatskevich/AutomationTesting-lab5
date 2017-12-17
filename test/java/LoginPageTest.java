import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.login.LoginPage;
import pages.main.MainPage;

/**
 * Created by Asus on 25.11.2017.
 */
public class LoginPageTest {

    WebDriver driver;
    LoginPage loginPage= new LoginPage(driver);

    private final String EMAIL = "vimtskch";
    private final String PASSWORD = "1qaz2wsx";
    private final String WRONG_PASSWORD = "123";

    @BeforeMethod
    public void setUp() {
        loginPage.initDriver();
    }
    @Test
    public void loginTest() throws Exception {
        loginPage.login(EMAIL,PASSWORD);
        MainPage mainPage= new MainPage(driver);
        String singInName= mainPage.getUserName();
        Assert.assertEquals(EMAIL,singInName);
    }

    @Test
    public void invalidLoginTest() throws Exception {
        loginPage.login(EMAIL,WRONG_PASSWORD);
        loginPage.massageIsDisplayed();
    }
    @AfterMethod
    public void stopBrowser() {
        loginPage.closeDriver();
    }
}