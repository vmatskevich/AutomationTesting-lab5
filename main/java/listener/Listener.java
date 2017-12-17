package listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Created by Vika on 17.12.2017.
 */
public class Listener implements WebDriverEventListener{
    public void beforeAlertAccept(WebDriver webDriver) {
        System.out.println("before Alert Accept : " + webDriver.toString());
    }

    public void afterAlertAccept(WebDriver webDriver) {
        System.out.println("After alert accept : " + webDriver.toString());
    }

    public void afterAlertDismiss(WebDriver webDriver) {
        System.out.println("after Alert Dismiss : " + webDriver.toString());
    }

    public void beforeAlertDismiss(WebDriver webDriver) {
        System.out.println("before Alert Dismiss : " + webDriver.toString());
    }

    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Before navigating to: '" + s + "'");
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Navigated to:'" + s + "'");
    }

    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("Navigating back to previous page");
    }

    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("Navigated back to previous page");
    }

    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("Navigating forward to next page");
    }

    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("Navigated forward to next page");
    }

    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("before Navigate Refresh : " + webDriver.toString());
    }

    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("after Navigate Refresh : " + webDriver.toString());
    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Trying to find Element By : " + by.toString());
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Found Element By : " + by.toString());
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Trying to click on: " + webElement.toString());
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Clicked on: " + webElement.toString());
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Value of the:" + webElement.toString()+ " before any changes made");
    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Element value changed to: " + webElement.toString());
    }

    public void beforeScript(String s, WebDriver webDriver) {
        System.out.println("Before Script : " + s);
    }


    public void afterScript(String s, WebDriver webDriver) {
        System.out.println("Before Script : " + s);
    }

    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("Exception occured: " + throwable);
    }
}
