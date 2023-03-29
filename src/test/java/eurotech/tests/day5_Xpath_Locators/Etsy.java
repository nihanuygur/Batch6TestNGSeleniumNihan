package eurotech.tests.day5_Xpath_Locators;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Etsy {
    public static void main(String[] args) {

    /*
    Test Case 2
    go to ETSY
    search selenium
    click on search button
    print number of results
     */

        //USE XPATH LOCATOR ONLY

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.etsy.com/");
        driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("selenium");
        driver.findElement(By.xpath("//button[contains(@class,'global')]")).click();
        System.out.println(driver.findElement(By.xpath("//*[@class='wt-display-inline-flex-sm']/span")).getText());

        driver.close();
    }
}
