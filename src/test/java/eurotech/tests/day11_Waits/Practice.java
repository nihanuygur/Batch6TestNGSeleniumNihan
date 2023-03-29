package eurotech.tests.day11_Waits;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test2() {
        driver.get("https://demoqa.com");

        driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();

        List<WebElement> alertOptions = driver.findElements(By.xpath("//*[text()='Browser Windows']/../../li"));

        System.out.println("alertOptions.size() = " + alertOptions.size());
        WebDriverWait wait = new WebDriverWait(driver, 15);

        wait.until(ExpectedConditions.elementToBeClickable(alertOptions.get(1)));
        alertOptions.get(1).click();

        driver.findElement(By.cssSelector("#timerAlertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @Test
    public void test1() {
        driver.get("https://demoqa.com");
        driver.findElement(By.cssSelector(".banner-image")).click();
        String currentId = driver.getWindowHandle();

        Set<String> allWindowsId = driver.getWindowHandles();

        for (String id : allWindowsId) {
            if (!id.equals(currentId)) {
                driver.switchTo().window(id);
            }
        }
        driver.findElement(By.cssSelector(".navbar__tutorial-menu--menu-bars")).click();
        driver.findElement(By.xpath("//*[text()='Frameworks & Libraries']")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//a[@title='TestNG']/../a"));

        WebDriverWait wait = new WebDriverWait(driver, 15);

        wait.until(ExpectedConditions.elementToBeClickable(elements.get(1)));

        System.out.println("elements.get(1).getText() = " + elements.get(1).getText());
        elements.get(1).click();

        System.out.println("driver.getTitle() = " + driver.getTitle());

        WebElement element = driver.findElement(By.xpath("//h2[text()='TestNG Tutorial with Selenium']"));
        Assert.assertTrue(element.isEnabled(), "Verifying 'TestNG Tutorial with Selenium' post is visible");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
