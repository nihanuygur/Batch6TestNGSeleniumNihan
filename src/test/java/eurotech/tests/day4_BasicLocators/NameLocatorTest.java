package eurotech.tests.day4_BasicLocators;


import com.github.javafaker.Faker;
import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_in");

        Faker faker = new Faker();

        driver.findElement(By.id("accept-cookie-notification")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("user[login]")).sendKeys(faker.internet().emailAddress());

        driver.findElement(By.name("user[password]")).sendKeys(faker.internet().password());

        driver.findElement(By.id("user_submit")).click();









        Thread.sleep(2000);
//        driver.close();
    }
}
