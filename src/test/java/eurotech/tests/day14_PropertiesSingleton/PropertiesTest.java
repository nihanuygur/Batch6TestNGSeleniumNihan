package eurotech.tests.day14_PropertiesSingleton;

import eurotech.utilities.ConfigurationReader;
import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.security.Key;

public class PropertiesTest {
    @Test
    public void test1() throws InterruptedException {
        // ClassName from day 4

//        WebDriver driver = WebDriverFactory.getDriver("chrome");
//        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browserrr")); // invalid browser type
//        System.out.println("Browser = " + ConfigurationReader.get("browserrr")); // returns null
//java.lang.NullPointerException: Cannot invoke "String.toLowerCase()" because "browserType" is null

//        WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser")); // if 'browser' is correct,
        // hoverOver command and click it will bring you to 'configuration.properties'
        System.out.println("Browser = " + ConfigurationReader.get("browser"));

//        driver.get("http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));
        System.out.println("url = " + ConfigurationReader.get("url"));

        driver.findElement(By.id("rcc-confirm-button")).click();

        Thread.sleep(2000);
//        driver.findElement(By.name("email")).sendKeys("eurotech@gmail.com");
        driver.findElement(By.name("email")).sendKeys(ConfigurationReader.get("userTeacher"));

//        driver.findElement(By.name("password")).sendKeys("Test12345!");
        driver.findElement(By.name("password")).sendKeys(ConfigurationReader.get("userPassword") + Keys.ENTER);

//        driver.findElement(By.id("loginpage-form-btn")).click(); // Keys.ENTER mimics the keyboard actions
        Thread.sleep(2000);


        String text = driver.findElement(By.className("my-2")).getText();
        System.out.println("text = " + text);


        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test2() {
        //configuration.properties:
        //browser=chrome
        //browser=firefox
        // it will choose the latest one as a browser,and it will not give error

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        System.out.println("Browser = " + ConfigurationReader.get("browser"));

        driver.get(ConfigurationReader.get("url"));
        System.out.println("url = " + ConfigurationReader.get("url"));

        System.out.println("userTeacher = " + ConfigurationReader.get("userTeacher"));
        System.out.println("userPassword = " + ConfigurationReader.get("userPassword"));
    }

    @Test
    public void test3() {
//        SingletonClassExample singleton = new SingletonClassExample(); // private constructor prevent to create obj
        SingletonClassExample singleton1 = SingletonClassExample.getInstanceOfSingletonClassExample();
        SingletonClassExample singleton2 = SingletonClassExample.getInstanceOfSingletonClassExample();


    }

}
