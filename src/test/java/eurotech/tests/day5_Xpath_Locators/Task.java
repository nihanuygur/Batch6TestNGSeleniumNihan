package eurotech.tests.day5_Xpath_Locators;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Task {
    public static void main(String[] args) {
        /*
    Test Case 1
    open the browser
    go to Ebay
    write selenium in search box
    verify that results contains selenium
     */

    /*
    Test Case 2
    go to ETSY
    search selenium
    click on search button
    print number of results
     */

        //USE XPATH LOCATOR ONLY
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
//        driver.get();
    }
}
