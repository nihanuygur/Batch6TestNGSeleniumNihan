package eurotech.tests.day5_Xpath_Locators;

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
        //USE XPATH LOCATOR ONLY

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.findElement(By.xpath("//input[contains(@class,'gh-tb')]")).sendKeys("selenium");
        driver.findElement(By.xpath("//*[@value='Search']")).click();

        String actualText = driver.findElement(By.xpath("//*[contains(text(),' results for ')]/span[2]")).getText();
        String expectedText = "selenium";

        if (actualText.toLowerCase().contains(expectedText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        driver.close();

    }
}
