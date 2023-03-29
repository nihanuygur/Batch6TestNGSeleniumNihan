package eurotech.tests.day11_Waits;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void test1() {
        driver.get("https://demoqa.com");
        WebDriverWait wait = new WebDriverWait(driver,20);


        WebElement element = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        element.click();
        WebElement element1 = driver.findElement(By.xpath("(//ul[@class='menu-list'])[3]/li[2]"));
        element1.click();


        WebElement element2 = driver.findElement(By.cssSelector("#alertButton"));
        wait.until(ExpectedConditions.elementToBeClickable(element2));
        element2.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);

        driver.close();

    }
}
