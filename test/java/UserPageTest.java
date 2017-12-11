import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Vika on 11.12.2017.
 */
public class UserPageTest {
    WebDriver driver;
    UserPage userPage = new UserPage(driver);
    @BeforeMethod
    public void setUp() {
        userPage.initDriver();
    }
    @Test
    public void isThisUser() {
       Assert.assertTrue(userPage.isThisUserPage());
    }
    @Test
    public void tweetIsPublished() {
        Assert.assertTrue(userPage.createNewTweet());
    }
    @AfterMethod
    public void stopBrowser() {
        userPage.closeDriver();
    }
}
