package eurotech.tests.day6_Css_Selector;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelectorTest {
    public static void main(String[] args) {
        // set up browser
        // navigate to "http://eurotech.study/login"
        // locate email, password, login button with CSS
        // enter email - password value and click button
        // close the browser

        // enter email address as "eurotech@gmail.com"
        // enter password as "Test12345!"

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement acceptButton = driver.findElement(By.cssSelector("#rcc-confirm-button"));
        WebElement email = driver.findElement(By.cssSelector("#loginpage-input-email"));
        WebElement password = driver.findElement(By.cssSelector("[placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#loginpage-form-btn"));


        acceptButton.click();
        email.sendKeys("eurotech@gmail.com");
        password.sendKeys("Test12345!");
        loginButton.click();

        driver.close();



    }
}

