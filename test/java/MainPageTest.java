import org.junit.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Vika on 11.12.2017.
 */
public class MainPageTest {
    WebDriver driver;
    MainPage mainPage = new MainPage(driver);
    @BeforeMethod
    public void setUp() {
        mainPage.initDriver();
    }
    @Test
    public void displayedPosts() {
        Assert.assertTrue(mainPage.postsAreDisplayed());
    }

    @Test
    public void backToTop(){
        Driver.scroll(250);
        mainPage.clickOnHomeButton();
        Assert.assertTrue(Driver.getPosition() == 0);
    }
    @AfterMethod
    public void stopBrowser() {
        mainPage.closeDriver();
    }
}
