package eurotech.tests.day7_testNG;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FirstTestNgTest {

    // TestNg will execute the methods alphabetical

    @Test
    public void C(){

        System.out.println("This is my first test");
    }


    @Test
    public void B(){
        System.out.println("This is my second test");

    }

    @Test
    public void A() {
        System.out.println("This is my third test");
    }
}
