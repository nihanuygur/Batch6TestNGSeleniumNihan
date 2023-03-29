package eurotech.tests.day13_webTables;

import eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement target = driver.findElement(By.xpath("//h3[text()='Demo Table 2']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", target);
    }

    @Test
    public void printTable() {
        // print the second table's all information
        WebElement table1 = driver.findElement(By.xpath("//table[@border='1']"));
        System.out.println(table1.getText());

    }

    @Test
    public void getAllHeaders() {
        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@border='1']/thead/tr/th"));
        System.out.println("allHeaders.size() = " + allHeaders.size());
        for (WebElement header : allHeaders) {
            System.out.println("header.getText() = " + header.getText());
        }
        System.out.println("****************************");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        System.out.println("rows.size() = " + rows.size());
        for (WebElement row : rows) {
            System.out.println("row.getText() = " + row.getText());
        }
    }

    @Test
    public void getRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        // print second row
        System.out.println("rows.get(1) = " + rows.get(1).getText());

        // print second row
        WebElement clockTower = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]"));
        System.out.println("clockTower.getText() = " + clockTower.getText());

        // print all rows one by one
        for (int i = 1; i <= rows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[" + i + "]"));
            System.out.println("row.getText() = " + row.getText());
        }
    }

    @Test
    public void getOneCell() {
        // print Mecca
        WebElement element = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[2]"));
        System.out.println("element.getText() = " + element.getText());
    }

    @Test
    public void getAllCellInOneRow() {

        List<WebElement> financialCenter = driver.findElements(By.xpath("//table[@border='1']/tbody/tr[1]/td"));
        System.out.println("financialCenter.size()= " + financialCenter.size());
        for (WebElement center:financialCenter) {
            System.out.println("center.getText() = " + center.getText());
        }
    }

    @Test
    public void printAllCellByIndex() {

        int rowNumber = getNumberOfRows();
        int colNUmber = getNumberOfCol();

        System.out.println("Row size " + rowNumber);
        System.out.println("Col size " + colNUmber);

        //iterate each row on the table
        for (int i = 1; i <= rowNumber; i++) {

            //iterate each cell in the row
            for (int j = 1; j < colNUmber; j++) {

                String cellXpath = "//table[@border='1']/tbody/tr[" + i + "]/td[" + j + "]";
                //  System.out.println(cellXpath);
                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(" " + cell.getText());

            }
        }
    }

    private int getNumberOfCol() {
        List<WebElement> column = driver.findElements(By.xpath("//table[@border='1']/thead/tr/th"));
        return column.size();
    }

    private int getNumberOfRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        return rows.size();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
