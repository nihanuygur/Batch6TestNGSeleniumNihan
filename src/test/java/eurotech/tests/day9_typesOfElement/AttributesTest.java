package eurotech.tests.day9_typesOfElement;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributesTest {
    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.cssSelector("#userName"));

        System.out.println("autocomplete: " + fullName.getAttribute("autocomplete"));
        System.out.println("id: " + fullName.getAttribute("id"));
        System.out.println("placeholder: " + fullName.getAttribute("placeholder"));
        System.out.println("type: " + fullName.getAttribute("type"));
        System.out.println("class: " + fullName.getAttribute("id"));

        System.out.println("outerHTML : " + fullName.getAttribute("outerHTML"));
        System.out.println("innerHTML : " + fullName.getAttribute("innerHTML"));

        System.out.println(driver.findElement(By.cssSelector("#userName-wrapper")).getAttribute("innerHTML"));
        // brings children
        System.out.println(driver.findElement(By.cssSelector("#userName-wrapper")).getAttribute("outerHTML"));
        // brings itself

        System.out.println("driver.getPageSource = " + driver.getPageSource());




        driver.close();

    }
}
