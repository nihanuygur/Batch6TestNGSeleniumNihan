package eurotech.tests.day15_POM_PageObjectModel;

import eurotech.Pages.LoginPage;
import eurotech.tests.TestBase;
import eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void positiveTest() throws InterruptedException {

        driver.get(ConfigurationReader.get("url"));

        loginPage.iUnderstandButton.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("userTeacher"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("userPassword"));
        loginPage.loginButton.click();


        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard",
                                        "Verifying that user successfully logged in ");
        //todo  verify login successfully
    }

    @Test
    public void loginWithMethod() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        String userTeacher = ConfigurationReader.get("userTeacher");
        String userPassword = ConfigurationReader.get("userPassword");
        loginPage.login(userTeacher, userPassword);
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard",
                                        "Verifying that user successfully logged in ");

    }

    @Test
    public void loginAsTeacher() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard",
                                         "Verifying that user successfully logged in ");

    }
    @Test
    public void loginAsStudent() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsStudent();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard",
                                          "Verifying that user successfully logged in ");
    }



}
