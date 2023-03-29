package eurotech.tests.day6_Css_Selector;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Wikipedia {
    public static void main(String[] args) {
          /*
     Test Case 2 (Optional)
    Go to Wikipedia
    enter search "selenium web driver"
    click on search button
    click on Selenium Software
    verify that title contains Selenium
    and verify that URL ends with "Selenium_(software)"
     */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org");

        driver.findElement(By.cssSelector("input#searchInput")).sendKeys("selenium web driver");
        driver.findElement(By.cssSelector("button[class*='pure-button']")).click();
        driver.findElement(By.cssSelector(".mw-search-result-heading>a")).click();
        driver.findElement(By.cssSelector("a[href='/wiki/Selenium_(software)']")).click();

        if (driver.getTitle().toLowerCase().contains("selenium")){
            System.out.println("Title passed");
        }else {
            System.out.println("Title failed");
        }
        if (driver.getCurrentUrl().endsWith("Selenium_(software)")){
            System.out.println("Url passed");
        }else{
            System.out.println("Url failed");
        }
        driver.close();

    }
}
