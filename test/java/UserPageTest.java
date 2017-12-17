import driver.Driver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.user.UserPage;

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
    public void searchInTwiTest(){
        userPage.searchInTwi();
        String actualUrl = Driver.getDriver().getTitle();
        Assert.assertEquals(actualUrl,"https://twitter.com/search?src=typd&q=hello");
        Assert.assertTrue(userPage.getSearchResult());
    }

    @AfterMethod
    public void stopBrowser() {
        userPage.closeDriver();
    }
}
