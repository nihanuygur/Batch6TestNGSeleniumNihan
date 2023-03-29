package eurotech.tests.day4_BasicLocators;

import com.github.javafaker.Faker;
import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement userNameInput = driver.findElement(By.id("userName"));

        Faker faker = new Faker();
        userNameInput.sendKeys(faker.name().fullName());

        WebElement userEmailInput = driver.findElement(By.id("userEmail"));
        userEmailInput.sendKeys(faker.internet().emailAddress());

        Thread.sleep(2000);
        driver.close();


    }
}
