package eurotech.tests.day3_webElement_intro;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLNotChanged {
    public static void main(String[] args) throws InterruptedException {

        // open Chrome browser
        // go to http://eurotech.study/login
        // click login button
        // verify that URL not changed

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        Thread.sleep(2000);

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        String expectedURL = driver.getCurrentUrl();

        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();

        String actualURL = driver.getCurrentUrl();



        if (expectedURL.equals(actualURL)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
//        boolean result = driver.getCurrentUrl().equals("http://eurotech.study/login");
//        System.out.println(result);

        Thread.sleep(2000);
        driver.close();





    }
}
