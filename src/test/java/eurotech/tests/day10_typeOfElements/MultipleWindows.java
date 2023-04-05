package eurotech.tests.day10_typeOfElements;

import eurotech.utilities.BrowserUtils;
import eurotech.utilities.Driver;
import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void twoWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        // get the ID of current page
        String windowS_Id = driver.getWindowHandle(); // current window's ID
        System.out.println("windowS_Id = " + windowS_Id);

        Set<String> windowHandles = driver.getWindowHandles(); // all windows' ID

        for (String handle : windowHandles) {
            // handle keeping all windows id one by one
            if (!handle.equals(windowS_Id)) {
                driver.switchTo().window(handle);
            }
        }
        Thread.sleep(2000);

        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);
        Assert.assertNotEquals(titleAfterClick,titleBeforeClick, "Verifying Title is different");

    }

    @Test
    public void multipleWindows() {

        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        WebElement clickHereBtn = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHereBtn.click();
        clickHereBtn.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
            if (driver.getTitle().equals("New Window")) {
                break;
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
    @Test
    public void testBrowserUtils() {
        Driver.get().get("https://the-internet.herokuapp.com/windows");

        System.out.println("driver.getTitle() = " + Driver.get().getTitle());

        WebElement click_here = Driver.get().findElement(By.linkText("Click Here"));
        click_here.click();
        BrowserUtils.switchToWindow("New Window");
        BrowserUtils.waitFor(1);
        System.out.println("driver.getTitle() = " + Driver.get().getTitle());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
