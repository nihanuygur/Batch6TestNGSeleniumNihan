package eurotech.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgAssertion {
    @Test
    public void test1() {
        System.out.println("verifying whether login is succesful");
        String  expectedTitle = "title";
        String  actualTitle = "title";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void test2() {
        String  expectedTitle = "Euro";
        String  actualTitle = "Eurotech";

//        Assert.assertTrue(actualTitle.contains(expectedTitle));
        Assert.assertTrue(actualTitle.contains(expectedTitle),"ActualTitle does not start with the expectedTitle");
        // if test is failed, it  will print this string message in the console
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"ActualTitle does not start with the expectedTitle");

    }

    @BeforeMethod
    public void setUp() {


        System.out.println("setting up browser");
        System.out.println("navigate to the Url");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("closing the browser");
    }


}
