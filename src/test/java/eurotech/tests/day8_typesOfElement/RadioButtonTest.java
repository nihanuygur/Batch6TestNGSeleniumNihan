package eurotech.tests.day8_typesOfElement;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void testName() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");

        // verify that "Vegetables radio button selected by default"
        Thread.sleep(2000);
        WebElement vegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']/../input"));

        Assert.assertTrue(vegetablesRadio.isSelected(), "verifying \"Vegetables radio button selected by default\"");

        // verify that "Legumes" radio button is NOT selected
        // click "Legumes"
        // verify Legumes is selected
        // verify Vegetables is NOT selected

        WebElement legumesRadio = driver.findElement(By.xpath("//div[text()='Legumes']/../input"));
        Assert.assertFalse(legumesRadio.isSelected(), "verifying \"Legumes radio button is not selected by default\"");

        WebElement legumesClick = driver.findElement(By.xpath("//div[text()='Legumes']"));
        legumesClick.click();

        Assert.assertTrue(legumesRadio.isSelected(), "verifying \"Legumes radio button is selected by default\"");
        Assert.assertFalse(vegetablesRadio.isSelected(), "verifying \"Vegetables radio button is not selected by default\"");


        driver.close();
    }

    @Test
    public void test2() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");


    }
}
