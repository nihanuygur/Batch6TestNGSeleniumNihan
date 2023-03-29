package eurotech.tests.day3_webElement_intro;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task {
    public static void main(String[] args) throws InterruptedException {

        // open Chrome browser
        // navigate to "http://eurotech.study/login"
        // enter username and password
        // email "eurotech@gmail.com" & password "Test12345!"
        // Verify login successfully
        // Verify that Dashboard text is exist

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        Thread.sleep(2000);

        driver.findElement(By.id("rcc-confirm-button")).click();

        driver.findElement(By.id("loginpage-input-email")).sendKeys("eurotech@gmail.com");

        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys("Test12345!");

        driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(2000);
        
        String expected ="Dashboard";
        String actual = driver.findElement(By.id("dashboard-h1")).getText();

        if (expected.equals(actual)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
