package eurotech.tests.day14_PropertiesSingleton;

import eurotech.tests.TestBase;
import eurotech.utilities.ConfigurationReader;
import eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {
    /**
     * Task:
     * Declare WebDriver object  at the class level
     * Create a setUp method (@BeforeMethod) where you initialize the driver
     * Create a test method (@Test) where you login by reading url and credentials from properties file
     * Create a tearDown method (@AfterMethod) where you close the driver
     */



    @Test
    public void testName() {
        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();
        driver.findElement(By.cssSelector("#loginpage-input-email")).sendKeys(ConfigurationReader.get("userTeacher"));
        driver.findElement(By.cssSelector("#loginpage-form-pw-input")).sendKeys(ConfigurationReader.get("userPassword"));
        driver.findElement(By.xpath("//*[@type='submit']")).click();

    }


}
