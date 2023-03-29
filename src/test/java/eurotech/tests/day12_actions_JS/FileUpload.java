package eurotech.tests.day12_actions_JS;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void fileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileBtn = driver.findElement(By.cssSelector("[type=file]"));
        System.out.println("chooseFileBtn = " + chooseFileBtn);
        chooseFileBtn.sendKeys("/Users/nihanuygur/Desktop/EurotechBatch6.pages");
        driver.findElement(By.cssSelector("#file-submit")).click();

        String actualText = driver.findElement(By.cssSelector("#uploaded-files")).getText();
        String expectedText = "EurotechBatch6.pages";
        Assert.assertEquals(actualText,expectedText,"Verifying file is uploaded");
    }

    @Test
    public void dynamicWay() {
        // /src/test + right click + new +Directory + resources
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        String projectPath =System.getProperty("user.dir");
        String  filePath = "src/test/resources/EuroTechBatch6.txt";
        driver.get("https://the-internet.herokuapp.com/upload");

        String fullPath = projectPath+"/"+filePath;
        WebElement chooseFileBtn = driver.findElement(By.cssSelector("[type=file]"));
        chooseFileBtn.sendKeys(fullPath);
        driver.findElement(By.cssSelector("#file-submit")).click();

        String actualText = driver.findElement(By.cssSelector("#uploaded-files")).getText();
        String expectedText = "EuroTechBatch6.txt";
        Assert.assertEquals(actualText,expectedText,"Verifying file is uploaded");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
