package eurotech.tests.day16_POM2;

import eurotech.Pages.DashboardPage;
import eurotech.Pages.LoginPage;
import eurotech.tests.TestBase;
import eurotech.utilities.BrowserUtils;
import eurotech.utilities.ConfigurationReader;
import eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    @Test
    public void dashBoardMenu() {
        /*
        Task
        Go to http://www.eurotech.study/
        Login with teacher credentials
        Get the text of the dashboard and verify following menu
                      Developers
                      All Posts
                      My Account
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();

        String expectedText ="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Developers");
        expectedList.add("All Posts");
        expectedList.add("My Account");

        ArrayList<String> actualList1 = new ArrayList<>();
        //1 way

        List<WebElement> dashboardMenu = dashboardPage.menuList;
        for (WebElement menu : dashboardMenu) {
            System.out.println("menu.getText() = " + menu.getText());
        }

        // 2 way
        for (WebElement element : dashboardPage.menuList) {
            System.out.println("element.getText() = " + element.getText());
            actualList1.add(element.getText());
        }
        Assert.assertEquals(actualList1,expectedList);

        // 3 way
        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.menuList);
        Assert.assertEquals(actualList,expectedList);

    }
    @Test
    public void navigateMenu() {
/*
        Go to http://www.eurotech.study/login
        Login with teacher credentials
        Navigate to All Posts menu and verify url is http://eurotech.study/posts
        Navigate to Developers menu and verify url is http://eurotech.study/profiles
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();

        String expectedText ="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");

        dashboardPage.allPosts.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts", "Verifying All post menu's Url");

        dashboardPage.developers.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles", "Verifying Developers menu's Url");


    }

    @Test
    public void navigate2() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();

        String expectedText ="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");

        dashboardPage.navigateMenu("All Posts");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts", "Verifying All post menu's Url");

//        dashboardPage.navigateMenu("Developer");  // Unable to locate // No such element exception
        dashboardPage.navigateMenu("Developer");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles", "Verifying Developers menu's Url");
    }
    @Test
    public void navigate3() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();

        String expectedText ="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");

        BrowserUtils.hover(dashboardPage.myAccount);
        dashboardPage.navigateSubMenu("My Posts");
    }
}
