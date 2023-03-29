package eurotech.tests.day8_typesOfElement;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgAssertions {

    @Test
    public void test1() {
        System.out.println("verifying whether login is succesful");
        String  expectedTitle = "title";
        String  actualTitle = "title";
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test
    public void test2() {
        Assert.assertFalse(8<1, "Asserting 8 to be less than 1");
    }

    @Test
    public void test3() {
        Assert.assertNotEquals("Title", "title");
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
