package eurotech.tests.day17_POM3;

import eurotech.Pages.DashboardPage;
import eurotech.Pages.LoginPage;
import eurotech.Pages.PostPage;
import eurotech.tests.TestBase;
import eurotech.utilities.BrowserUtils;
import eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardTest2 extends TestBase {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    PostPage postPage=new PostPage();
    @Test
    public void verifyList() {
        /**
        Go to http://www.eurotech.study/
        Login with teacher credentials
        Verify log in successfully
        verify following menu
                      Edit Profile
                      Add Experience
                      Add Education
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();

        String expectedText ="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");

        ArrayList<String> expectedList = new ArrayList<>(Arrays.asList("Edit Profile","Add Experience","Add Education"));

        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.dashboardList);
        Assert.assertEquals(actualList,expectedList,"Verify Edit Profile-Add Experience-Add Education are visible");
//
//        Assert.assertTrue(dashboardPage.isDisplayedBln("Edit Profile"),"Verify 'Edit Profile' are visible");
//        Assert.assertTrue(dashboardPage.isDisplayedBln("Add Experience"),"Verify 'Add Experience' are visible");
//        Assert.assertTrue(dashboardPage.isDisplayedBln("Add Education"),"Verify 'Add Education' are visible");


    }

    @Test
    public void test2() {
        /**
         Go to http://www.eurotech.study/
         Login with teacher credentials
         Navigate to My Posts and verify that submit button is true and visible then
         Navigate to Log Out and verify that log out successfully
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();

        String expectedText ="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");

        BrowserUtils.hover(dashboardPage.myAccount);
        dashboardPage.navigateSubMenu("My Posts");

        Assert.assertEquals(postPage.submitBtn.getAttribute("value"),"Submit", "Verifying text is Submit");
        BrowserUtils.verifyElementDisplayed(postPage.submitBtn);
//        Assert.assertTrue(postPage.submitBtn.isDisplayed(),"Verifying Submit button is visible");

        BrowserUtils.hover(dashboardPage.myAccount);
        dashboardPage.navigateSubMenu("Logout");
        Assert.assertTrue(dashboardPage.isDisplayedBln("Sign In"),"Verifying Sign in button is visible");
    }

    @Test
    public void postComment() {
        /**
         Go to http://www.eurotech.study/
         Login with teacher credentials
         Navigate to My Account and navigate to My Posts
         Fill the title and post area
         Click submit button
         Verify that post saved successfully
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();

        String expectedText ="Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in successfully");

        BrowserUtils.hover(dashboardPage.myAccount);
        dashboardPage.navigateSubMenu("My Posts");

//        postPage.titleInput.sendKeys("Batch6Selenium");
//        postPage.postInput.sendKeys("We are learning selenium");
//
//        postPage.submitBtn.click();

        postPage.postComment("Hello","We created post method");

        BrowserUtils.verifyElementDisplayed(postPage.postCreatedMessage);


    }
}
