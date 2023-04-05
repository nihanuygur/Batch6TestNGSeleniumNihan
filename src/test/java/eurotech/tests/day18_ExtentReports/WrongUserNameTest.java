package eurotech.tests.day18_ExtentReports;

import eurotech.Pages.DashboardPage;
import eurotech.Pages.LoginPage;
import eurotech.tests.TestBase;
import eurotech.utilities.ConfigurationReader;
import eurotech.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUserNameTest extends TestBase {


    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void wrongUserName() {
        // give a name to the current test
        extentLogger = report.createTest("Login with wrong username Test");

        // test steps
        extentLogger.info("Open the Browser");
        extentLogger.info("Go to Url http://eurotech.study/login");
        Driver.get().get(ConfigurationReader.get("url"));

        extentLogger.info("Click I UnderStand Button");
//        loginPage.iUnderstandButton.click();

        extentLogger.info("Enter invalid username");
        loginPage.usernameInput.sendKeys("euro@gmail.com");

        extentLogger.info("Enter valid password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("userPassword"));

        extentLogger.info("Click Login Button");
        loginPage.loginButton.click();

        extentLogger.info("Verify user is not logged in");
        Assert.assertEquals(loginPage.warningMessage.getText(),"Invalid Credentials!","Verifying the warning message");

        extentLogger.pass("Passed");

    }

    @Test
    public void wrongPassword() {
        // Task
        // navigate http://eurotech.study/login
        // enter valid username but invalid password
        // validate user can not login

        // give a name to the current test
        extentLogger = report.createTest("Login with wrong password Test");

        // test steps
        extentLogger.info("Open the Browser");
        extentLogger.info("Go to Url http://eurotech.study/login");
        Driver.get().get(ConfigurationReader.get("url"));

        extentLogger.info("Click I UnderStand Button");
        loginPage.iUnderstandButton.click();

        extentLogger.info("Enter valid username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("userTeacher"));

        extentLogger.info("Enter invalid password");
        loginPage.passwordInput.sendKeys("userPassword");

        extentLogger.info("Click Login Button");
        loginPage.loginButton.click();

        extentLogger.info("Verify user is not logged in");
        Assert.assertEquals(loginPage.warningMessage.getText(),"Invalid Credentials!","Verifying the warning message");

        extentLogger.pass("Passed");


    }
}
