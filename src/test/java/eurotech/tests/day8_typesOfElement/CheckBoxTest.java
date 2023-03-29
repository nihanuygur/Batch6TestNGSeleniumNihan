package eurotech.tests.day8_typesOfElement;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest {
    @Test
    public void testName() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        Assert.assertTrue(checkBox2.isSelected(), "verifying checkBox2 is selected by default");
        Assert.assertFalse(checkBox1.isSelected(), "verifying checkBox1 is not selected by default");

        checkBox1.click();
        Assert.assertTrue(checkBox1.isSelected(), "verifying checkBox1 is selected after clicking");

        checkBox2.click();
        Assert.assertFalse(checkBox2.isSelected(), "verifying checkBox2 is not selected after clicking");

        driver.close();

    }
}
