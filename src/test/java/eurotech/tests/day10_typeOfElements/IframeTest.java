package eurotech.tests.day10_typeOfElements;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        // first way switching iframe by id
        driver.switchTo().frame("mce_0_ifr");

        Thread.sleep(2000);

        WebElement textArea = driver.findElement(By.cssSelector("#tinymce"));
        textArea.clear();

        textArea.sendKeys("EuroTech was here");

        // second way switching iframe  by Index number
        driver.switchTo().parentFrame();
        driver.switchTo().frame(0);
        textArea.clear();

        textArea.sendKeys("EuroTech was here second");

        // third way switching iframe by Web Element
        driver.switchTo().parentFrame();
        WebElement iframe = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframe);
        textArea.clear();

        textArea.sendKeys("EuroTech was here third");

    }

    @Test
    public void nestedIframe() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
/*
HTML
    top
        left
        middle
        right
    bottom
 */
        // DEFAULT CONTENT
        // get MIDDLE text
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println("driver.findElement(By.cssSelector(\"#content\")).getText() = " + driver.findElement(By.cssSelector("#content")).getText());


//        driver.switchTo().parentFrame();
//        driver.switchTo().frame("frame-right");

        driver.switchTo().defaultContent(); //  go to top

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        System.out.println("driver.findElement(By.cssSelector(\"body\")).getText() = " + driver.findElement(By.cssSelector("body")).getText());


        driver.switchTo().defaultContent(); //  go to top

        driver.switchTo().frame("frame-bottom");
        System.out.println("driver.findElement(By.cssSelector(\"body\")).getText() = " + driver.findElement(By.cssSelector("body")).getText());

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
