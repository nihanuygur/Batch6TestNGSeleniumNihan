package eurotech.tests.day6_Css_Selector;


import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Ebay {
    public static void main(String[] args) {
        /*
        Test Case 1
        open the browser
        go to Ebay
        write selenium in search box
        verify that results contains selenium
        */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");

        driver.findElement(By.cssSelector("input[name='_nkw']")).sendKeys("selenium");
        driver.findElement(By.cssSelector("#gh-btn")).click();
        String result = driver.findElement(By.cssSelector(".srp-controls__count-heading>span~span")).getText();


        if (result.toLowerCase().contains("selenium")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        driver.close();


    }
}
