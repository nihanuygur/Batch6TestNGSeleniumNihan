package eurotech.tests.day2_webDriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class closeAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        Thread.sleep(2000);

        // close current tab
        driver.close();

        // after close, driver stopped, we need to assign again

        driver = new ChromeDriver();

        driver.get("https://www.eurotechstudy.com/en");

        Thread.sleep(2000);

        // quit closes all tabs in the browser
        driver.quit();

    }
}
