package eurotech.tests.day8_typesOfElement;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableDisableElements {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement textInput = driver.findElement(By.cssSelector("input[type='text']"));
        Assert.assertFalse(textInput.isEnabled(), "Verifying textInput is disable");

        driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();

        Thread.sleep(3000);
        Assert.assertTrue(textInput.isEnabled(), "Verifying textInput is enable");

        driver.close();

    }
}
