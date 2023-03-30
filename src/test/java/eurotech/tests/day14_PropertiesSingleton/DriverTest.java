package eurotech.tests.day14_PropertiesSingleton;

import eurotech.utilities.ConfigurationReader;
import eurotech.utilities.Driver;
import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DriverTest {
//    @Test
//    public void test1() throws InterruptedException {
//        WebDriver driver = Driver.get(); // String browser = ConfigurationReader.get("browser");
//                                         // Configuration.properties  --> browser=chrome
//
//        driver.get(ConfigurationReader.get("url"));
//
//        Thread.sleep(1000);
//        Driver.closeDriver();
//
//    }

    @Test
    public void test2() throws InterruptedException {
//        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(1000);
        Driver.closeDriver();
    }

//     WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
//     if we use like that it will open new browser
    // WebDriver driver = Driver.get();
    // with Singleton feature google will open in same browser

    @Test
    public void test3() throws InterruptedException {
//        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        WebDriver driver = Driver.get();
        driver.get("https://www.google.com.tr/");
        Thread.sleep(1000);
        Driver.closeDriver();
    }
}
