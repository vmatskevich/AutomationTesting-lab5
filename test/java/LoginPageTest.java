import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
    public void testIsSignedIn() throws Exception {
        MainPage mainPage=loginPage.loginSuccess(EMAIL,PASSWORD);
        String singInName= mainPage.getUserName();
        Assert.assertEquals(EMAIL,singInName);
    }

    @Test
    public void testFailedSignIn() throws Exception {
        ErrorLoginPage errorLoginPage=loginPage.loginFailed(EMAIL,WRONG_PASSWORD);
        Assert.assertTrue(errorLoginPage.massageAreDisplayed());
    }
    @AfterMethod
    public void stopBrowser() {
        loginPage.closeDriver();
    }
}