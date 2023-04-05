package eurotech.tests.day12_actions_JS;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void hoverOver() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);

        WebElement user1 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        actions.moveToElement(user1).perform();
        WebElement userName1 = driver.findElement(By.xpath("(//h5)[1]"));
        Assert.assertTrue(userName1.isDisplayed(), "Verifying user1 name is visible");

        WebElement user2 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[2]"));
        actions.moveToElement(user2).perform();
        WebElement userName2 = driver.findElement(By.xpath("(//h5)[2]"));
        Assert.assertTrue(userName2.isDisplayed(), "Verifying user2 name is visible");

        WebElement user3 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[3]"));
        actions.moveToElement(user3).perform();
        WebElement userName3 = driver.findElement(By.xpath("(//h5)[3]"));
        Assert.assertTrue(userName3.isDisplayed(), "Verifying user3 name is visible");

    }
    @Test
    public void hover() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");

        for (int i = 2; i <= 4; i++) {

            String xpathImg = "(//img)[" + i + "]";
            WebElement img = driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String textPath = "//h5[text()='name: user" + (i - 1) + "']";
            WebElement text = driver.findElement(By.xpath(textPath));
            System.out.println(textPath);

            Assert.assertTrue(text.isDisplayed(), "verify user" + (i - 1) + " is displayed");


        }
    }

    @Test
    public void dragDrop() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.get("http://globalsqa.com/demo-site/draganddrop/");
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//li[@id='Accepted Elements']")).click();

        WebElement iframe = driver.findElement(By.xpath("//div[@rel-title='Accepted Elements']/p/iframe"));

        driver.switchTo().frame(iframe);
        WebElement target = driver.findElement(By.id("droppable"));

        WebElement source2 = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(source2, target).perform();
        String actualMessage = driver.findElement(By.cssSelector("#droppable>p")).getText();
        Assert.assertTrue(actualMessage.equals("Dropped!"));

    }

    @Test
    public void dragDrop3() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.get("http://globalsqa.com/demo-site/draganddrop/");
        Actions actions = new Actions(driver);

        WebElement iframe = driver.findElement(By.xpath("//*[@rel-title='Photo Manager']/p/iframe"));

        driver.switchTo().frame(iframe);
        WebElement target = driver.findElement(By.cssSelector("div#trash"));
        WebElement source1 = driver.findElement(By.xpath("//*[text()='High Tatras']"));
        WebElement source2 = driver.findElement(By.xpath("//*[text()='High Tatras 2']"));
        WebElement source3 = driver.findElement(By.xpath("//*[text()='High Tatras 3']"));
        WebElement source4 = driver.findElement(By.xpath("//*[text()='High Tatras 4']"));

//        wait.until(ExpectedConditions.elementToBeClickable(target));

        actions.dragAndDrop(source1, target).perform();
        actions.dragAndDrop(source2, target).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(source3, target).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(source4, target).perform();
//        String actualMessage = driver.findElement(By.cssSelector("#droppable>p")).getText();
//        Assert.assertTrue(actualMessage.equals("Dropped!"));

    }

    @Test
    public void dragDrop2() {
        driver.get("https://demo.aspnetawesome.com/DragAndDropDemo");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        WebElement target = driver.findElement(By.cssSelector("div.dropZone"));
        WebElement source1 = driver.findElement(By.xpath("//div[text()='a']"));

        actions.dragAndDrop(source1, target).perform();

        int actualSize = driver.findElements(By.xpath("//*[@class='dropZone'][2]/div")).size();

        Assert.assertEquals(actualSize,1,"Verifying actual size is 1");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
