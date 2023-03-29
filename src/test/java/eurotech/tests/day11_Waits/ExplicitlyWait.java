package eurotech.tests.day11_Waits;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitlyWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void explicitlyWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//*[text()='Start']")).click();

        // How to wait explicitly wait?
        // Create an explicit obj wait
        WebDriverWait wait = new WebDriverWait(driver, 15);

        WebElement text = driver.findElement(By.cssSelector("#finish>h4"));
        wait.until(ExpectedConditions.visibilityOf(text));

        String expected = "Hello World!";
        Assert.assertEquals(text.getText(), expected, "verifying Hello World! text");


    }

    @Test
    public void explicitlyWait2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, 15);

        WebElement inputBox = driver.findElement(By.cssSelector("input[type=text"));
        WebElement enableBtn = driver.findElement(By.xpath("//*[text()='Enable']"));
        enableBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("EuroTech was here");

        WebElement message = driver.findElement(By.cssSelector("#message"));
        Assert.assertEquals(message.getText(),"It's enabled!");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
