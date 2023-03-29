package eurotech.tests.day3_webElement_intro;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement emailInput = driver.findElement(By.id("loginpage-input-email"));
        emailInput.sendKeys("Hello World!");

        Thread.sleep(1000);

        System.out.println("emailInput.getAttribute() = " + emailInput.getAttribute("value"));

        System.out.println("emailInput.getAttribute() = " + emailInput.getAttribute("placeholder"));



        driver.close();




    }
}
