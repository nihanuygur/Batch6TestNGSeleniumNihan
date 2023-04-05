package eurotech.tests.day12_actions_JS;

import eurotech.utilities.BrowserUtils;
import eurotech.utilities.Driver;
import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void hoverOver() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img1 = driver.findElement(By.xpath("(//img)[2]"));


        //Actions ---> class that contains all the user interactions
        Actions actions = new Actions(driver);

        //perform() --> perform the action complete the action
        //moveToElement() -- > move your mouse to web element (hover over)

        // HoverOver
        actions.moveToElement(img1).perform();

        WebElement user1Text = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user1Link = driver.findElement(By.linkText("View profile"));
        System.out.println("user1Link.getText() = " + user1Link.getText());


        System.out.println("user1Text.getText() = " + user1Text.getText());
    }
    @Test
    public void hover2BrowserUtils() {
        Driver.get().get("https://the-internet.herokuapp.com/hovers");

        WebElement img1 = Driver.get().findElement(By.xpath("(//img)[2]"));

        BrowserUtils.hover(img1);

        WebElement view_profile = Driver.get().findElement(By.linkText("View profile"));
        System.out.println("view_profile.getText() = " + view_profile.getText());

        Assert.assertEquals(view_profile.getText(),"View profile");

    }

    @Test
    public void dragAndDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);

        // Drag Drop
        actions.dragAndDrop(source,target).perform();
        WebElement verifyMessage= driver.findElement(By.xpath("//p[text()='Dropped!']"));

        // Verifying 1
        Assert.assertTrue(verifyMessage.isDisplayed());

        // Verifying 2
        Assert.assertEquals(verifyMessage.getText(),"Dropped!", "Verifying 'Dropped!' message is visible");

    }

    @Test
    public void dragANdDrop2() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);

        // Drag Drop Long way
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(3000).release().perform();

        WebElement verifyMessage= driver.findElement(By.xpath("//p[text()='Dropped!']"));

        // Verifying 1
        Assert.assertTrue(verifyMessage.isDisplayed());
    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
