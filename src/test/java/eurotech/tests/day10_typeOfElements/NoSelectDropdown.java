package eurotech.tests.day10_typeOfElements;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() {

        // verify that size is 25
        // print all list
        // verify that 4. element is banana
        // click cherry
        // verify banana is not selected

        driver.get("https://demo.aspnetawesome.com/");
        WebElement dropDownBtn = driver.findElement(By.xpath("(//div[@class='o-slbtn'])[5]"));
        dropDownBtn.click();

        List<WebElement> listDropdown = driver.findElements(By.xpath("(//ul[@class='o-mnits'])[5]/li"));
        System.out.println("listDropdown.size() = " + listDropdown.size());
        Assert.assertEquals(listDropdown.size(),25, "Verifying that size 25");

        for (WebElement item:listDropdown) {
            System.out.println("item.getText() = " + item.getText());
        }

        Assert.assertEquals(listDropdown.get(3).getText(),"Banana","Verify that 4. element is banana");

        listDropdown.get(4).click();
        WebElement selectedElement = driver.findElement(By.xpath("(//div[@class='o-cptn'])[5]"));
        Assert.assertEquals(selectedElement.getText(),"Cherry", "verify Cherry is  selected");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
