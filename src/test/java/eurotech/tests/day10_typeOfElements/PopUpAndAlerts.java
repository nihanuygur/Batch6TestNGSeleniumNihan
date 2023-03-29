package eurotech.tests.day10_typeOfElements;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=50eaa");
        driver.findElement(By.xpath("(//span[text()='Confirm'])[1]")).click();
        driver.findElement(By.xpath("(//span[text()='Yes'])[2]")).click();
        String expectedText = "You have accepted";
        Thread.sleep(1000);

        String actualText = driver.findElement(By.xpath("//p[text()='You have accepted']")).getText();
        Assert.assertEquals(actualText, expectedText, "Verifying 'You have accepted' is displayed");

    }

    @Test
    public void JSAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        String expectedResult;

        // result 1 JS alert + OK
        Alert alert = driver.switchTo().alert();
        alert.accept();
        expectedResult="You successfully clicked an alert";

        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        System.out.println("result 1 = " + result);
        Assert.assertEquals(result,expectedResult, "Verifying result 1 JS alert + OK");

        // result 2 JS Confirm + Cancel
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        alert.dismiss();
        expectedResult="You clicked: Cancel";
        result = driver.findElement(By.cssSelector("#result")).getText();
        System.out.println("result 2 = " + result);
        Assert.assertEquals(result,expectedResult, "Verifying result 2 JS Confirm + Cancel");

        // result 3 JS Confirm + Ok
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        alert.accept();
        expectedResult="You clicked: Ok";
        result = driver.findElement(By.cssSelector("#result")).getText();
        System.out.println("result 3 = " + result);
        Assert.assertEquals(result,expectedResult, "Verifying result 3 JS Confirm + Ok");

        // result 4 JS Prompt + Ok
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        alert.sendKeys("Girls are working");
        Thread.sleep(2000);
        alert.accept();
        result = driver.findElement(By.cssSelector("#result")).getText();
        System.out.println("result = " + result);

        // result 5 JS Prompt + Cancel
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        expectedResult="You entered: null";
        alert.sendKeys("Girls are working");
        Thread.sleep(2000);
        alert.dismiss();
        result = driver.findElement(By.cssSelector("#result")).getText();
        System.out.println("result = " + result);
        Assert.assertEquals(result,expectedResult, "Verifying result 5 JS Prompt + Cancel");

        // homework
        // verify all results above JS Alerts

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
