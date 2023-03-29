package eurotech.tests.day11_Waits;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }



    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();


//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // it will work findElement() method
        String expectedMessage = "It's gone!";
        String actualMessage = driver.findElement(By.xpath("//p[@id='message']")).getText();

        Assert.assertEquals(actualMessage,expectedMessage, "Verifying 'It's gone!' message displayed");

    }

    @Test
    public void test2() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement( By.xpath("//*[text()='Start']")).click();
        WebElement text = driver.findElement(By.cssSelector("#finish>h4"));
        String expected = "Hello World!";
        Assert.assertEquals(text.getText(),expected, "verifying Hello World! text");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
