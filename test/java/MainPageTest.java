import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.main.MainPage;

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
        mainPage.open();
    }
    @AfterMethod
    public void stopBrowser() {
        mainPage.closeDriver();
    }
}
