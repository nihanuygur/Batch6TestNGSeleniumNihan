package eurotech.tests.day7_testNG;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestNgAnnotation {

    @Test
    public void test1() {
        System.out.println("this is test1");
        System.out.println("some verification");

        System.out.println();

    }

    @Test
    public void test2() {
        System.out.println("this is test2");
        System.out.println("some verification");
        System.out.println();
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("setting up browser");
        System.out.println("navigate to the Url");
        System.out.println();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("closing the browser");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class method");
        System.out.println();
    }

    public void normalMethod() {
    }

    @AfterClass
    public void afterClass() {

        System.out.println("after class method");
    }
}
