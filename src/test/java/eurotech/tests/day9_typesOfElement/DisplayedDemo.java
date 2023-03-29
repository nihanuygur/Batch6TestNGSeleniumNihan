package eurotech.tests.day9_typesOfElement;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        driver.findElement(By.xpath("//a[contains(text(),'Example 1')]")).click();

        Thread.sleep(2000);

        WebElement button = driver.findElement(By.xpath("//button[text()='Start']"));
        WebElement helloText = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        Assert.assertFalse(helloText.isDisplayed(),"Verifying 'Hello World!' text is not displayed");

        button.click();
        Thread.sleep(5000);

        Assert.assertTrue(helloText.isDisplayed(),"Verifying 'Hello World!' text is displayed");

        driver.close();
    }
    @Test
    public void test2() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        driver.findElement(By.xpath("//a[contains(text(),'Example 2')]")).click();

        Thread.sleep(2000);

        WebElement button = driver.findElement(By.xpath("//button[text()='Start']"));

        button.click();
        Thread.sleep(6000);

        WebElement helloText = driver.findElement(By.xpath("//h4[text()='Hello World!']"));


        Assert.assertTrue(helloText.isDisplayed(),"Verifying 'Hello World!' text is displayed");

        driver.close();
    }
}
