package eurotech.tests.day3_webElement_intro;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {

        // open Chrome browser
        // go to http://eurotech.study/login
        // enter email address as "eurotech@gmail.com"
        // enter password as "Test12345!"
        // click login button
        // verify that confirmation message "Welcome Teacher" is visible


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        Thread.sleep(2000);

        // Click Understand btn
        driver.findElement(By.id("rcc-confirm-button")).click();

        // Enter UserName
        driver.findElement(By.id("loginpage-input-email")).sendKeys("eurotech@gmail.com");

        // Enter Password
        driver.findElement(By.name("password")).sendKeys("Test12345!");

        // Click Login btn
        driver.findElement(By.id("loginpage-form-btn")).click();


        String loginBtn=driver.findElement(By.id("loginpage-form-btn")).getAttribute("Login");
        System.out.println(loginBtn);

        Thread.sleep(2000);

        WebElement welcomeMessage = driver.findElement(By.id("dashboard-p1"));

        // we have two ways to get text from web pages
        // 1. getText() --> it will work %99, and it will return String
        System.out.println(welcomeMessage.getText());

        // 2. getAttribute() -->


        String expectedText = "Welcome Teacher";
        String actualText = welcomeMessage.getText();

        if (expectedText.equals(actualText)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        driver.close();








    }
}
