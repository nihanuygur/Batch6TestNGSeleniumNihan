package eurotech.tests.day13_webTables;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicWebTable {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void dynamicNegative() {
        driver.get("https://demoqa.com/webtables");
        WebElement kierra = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[3]/div/div[1]"));
        System.out.println("before click = " + kierra.getText());

        driver.findElement(By.xpath("//*[text()='Last Name']")).click();
        System.out.println("after click = " + kierra.getText());

//        Assert.assertEquals(kierra.getText(),"Kierra"); // fail
    }

    @Test
    public void dynamicPositive() {
        driver.get("https://demoqa.com/webtables");
        WebElement kierra = driver.findElement(By.xpath("//*[text()='Kierra']"));
        System.out.println("before click = " + kierra.getText());


        driver.findElement(By.xpath("//*[text()='Last Name']")).click();
        kierra = driver.findElement(By.xpath("//*[text()='Kierra']"));
        System.out.println("after click = " + kierra.getText());
        Assert.assertEquals(kierra.getText(),"Kierra");

//div[text()='alden@example.com']/../div[1]
    }

    @Test
    public void dynamic2() {
        driver.get("file:///Users/nihanuygur/Desktop/WebTable.html");
        WebElement marryCountry = driver.findElement(By.xpath("//td[text()='Mary']/../td[3]"));
        System.out.println("Before click = " + marryCountry.getText());

        WebElement emailBtn = driver.findElement(By.xpath("//th[text()='Email']"));
        emailBtn.click();
        driver.findElement(By.xpath("//th[text()='Name']")).click();

        marryCountry = driver.findElement(By.xpath("//td[text()='Mary']/../td[3]"));
        System.out.println("After click = " + marryCountry.getText());
        Assert.assertEquals(marryCountry.getText(),"Canada");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
