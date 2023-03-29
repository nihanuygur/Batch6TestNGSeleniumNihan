package eurotech.tests.day5_Xpath_Locators;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Wikipedia {
    public static void main(String[] args) throws InterruptedException {

        //USE XPATH LOCATOR ONLY
    /*
     Test Case 3 (Optional)
    Go to Wikipedia
    enter search "selenium web driver"
    click on search button
    click on Selenium Software
    verify that title contains Selenium
    and verify that URL ends with "Selenium_(software)"
     */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='searchInput']")).sendKeys("selenium web driver");
        driver.findElement(By.xpath("//*[text()='Search']")).click();
        driver.findElement(By.xpath("//a[@title='Selenium (software)']")).click();

        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();

        if(actualTitle.toLowerCase().contains("selenium")){
            System.out.println("Title contains Selenium");
        }else{
            System.out.println("Title failed");
        }

        if(actualUrl.endsWith("Selenium_(software)")){
            System.out.println("URL ends with \"Selenium_(software)\"");
        }else{
            System.out.println("URL failed");
        }

        driver.close();

    }
}
