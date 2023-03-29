package eurotech.tests.day9_typesOfElement;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() {
        driver.get("https://demoqa.com/select-menu");
        WebElement colorDropdown = driver.findElement(By.cssSelector("#oldSelectMenu"));

        Select select = new Select(colorDropdown);

        List<WebElement> colorOptions = select.getOptions();
        int expectedSize=11;
        int actualSize = colorOptions.size();

        // Verify there are 11 colors in this dropdown
        Assert.assertEquals(actualSize,expectedSize, "Verifying there are 11 color options");

        // print all the colors
        for (WebElement item : colorOptions) {
            System.out.println("item.getText() = " + item.getText());
        }

        // Verify the initial color /default color is Red
        String defaultColor = "Red";
        String actualDefaultColor = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDefaultColor,defaultColor,"Verifying the initial color /default color is Red" );

        // select Yellow  by visibleText and verify it has been selected
        select.selectByVisibleText("Yellow");
        Assert.assertTrue("Yellow".equals(select.getFirstSelectedOption().getText()),"verifying Yellow has been selected");

        // select Green  by index and verify it has been selected
        select.selectByIndex(2); // java index 2 html index 3, be careful
        Assert.assertTrue("Green".equals(select.getFirstSelectedOption().getText()),"verifying Green has been selected");

        // select Indigo by value and verify it has been selected
        select.selectByValue("8"); // java index 2 html index 3, be careful
        Assert.assertTrue("Indigo".equals(select.getFirstSelectedOption().getText()),"verifying Indigo has been selected");


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
