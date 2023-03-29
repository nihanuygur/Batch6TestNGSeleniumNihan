package eurotech.tests.day13_webTables;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
    }

    @Test
    public void getHeadersWithIndex() {
        int colNum = getColumnNumbers();

        for (int j = 1; j <= colNum; j++) {
            String path = "//table[@id='customers']//tr[1]/th[" + j + "]";
            WebElement element = driver.findElement(By.xpath(path));
            System.out.println("Cell " + j + ": " + element.getText());
        }
    }

    @Test
    public void getAllCellWithIndex() {
        int rowNum = getRowNumbers();
        int colNum = getColumnNumbers();

        for (int i = 2; i <= rowNum; i++) {
            System.out.println("Row : " + i);
            for (int j = 1; j <= colNum; j++) {
                String path = "//table[@id='customers']//tr[" + i + "]/td[" + j + "]";
                WebElement element = driver.findElement(By.xpath(path));
//                WebElement element2 = driver.findElement(By.xpath("//table[@id='customers']//tr[" + i + "]/td[" + j + "]"));
                System.out.println("Cell " + j + ": " + element.getText());
            }
            System.out.println();
        }
    }

    @Test
    public void dynamicWebTable() {

        driver.get("https://demoqa.com/webtables");
        WebElement kierra = driver.findElement(By.xpath("//div[text()='alden@example.com']/../div[1]"));
        System.out.println("before click = " + kierra.getText());

        driver.findElement(By.xpath("//*[text()='Last Name']")).click();
        kierra = driver.findElement(By.xpath("//div[text()='alden@example.com']/../div[1]"));
        System.out.println("after click = " + kierra.getText());
        Assert.assertEquals(kierra.getText(), "Alden");

    }

    private int getColumnNumbers() {
        List<WebElement> columns = driver.findElements(By.cssSelector("table#customers th"));
        System.out.println("columns.size() = " + columns.size());
        return columns.size();
    }

    private int getRowNumbers() {
        List<WebElement> rows = driver.findElements(By.cssSelector("table#customers tr"));
        System.out.println("rows.size() = " + rows.size());
        return rows.size();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
