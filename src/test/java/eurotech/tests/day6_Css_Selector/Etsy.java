package eurotech.tests.day6_Css_Selector;


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
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.etsy.com/");

        driver.findElement(By.cssSelector("#global-enhancements-search-query")).sendKeys("selenium");
        driver.findElement(By.cssSelector("button[value='Search']")).click();

        String result = driver.findElement(By.cssSelector(".wt-display-inline-flex-sm>span")).getText();

        System.out.println(result);

        driver.close();
    }
}
