package eurotech.tests.day4_BasicLocators;


import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PartialLinkText {
    public static void main(String[] args) throws InterruptedException {
        // open the browser "https://the-internet.herokuapp.com/dynamic_loading"
        // navigate to dynamic loading
        // click example2
        // verify that "Example 2: Element rendered after the fact"

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        Thread.sleep(2000);

        WebElement example2 = driver.findElement(By.partialLinkText("Example 2"));
        example2.click();

        WebElement text = driver.findElement(By.tagName("h4"));
        String actualText = text.getText();

        String expectedText = "Example 2: Element rendered after the fact";

        if (expectedText.equals(actualText)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }



        Thread.sleep(2000);
        driver.close();
    }
}
