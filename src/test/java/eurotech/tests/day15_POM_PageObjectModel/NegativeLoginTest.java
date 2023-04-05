package eurotech.tests.day15_POM_PageObjectModel;

import eurotech.Pages.LoginPage;
import eurotech.tests.TestBase;
import eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void wrongPassword1() {

        driver.get(ConfigurationReader.get("url"));

        WebElement confirmBtn = driver.findElement(By.cssSelector("#rcc-confirm-button"));
        WebElement emailField = driver.findElement(By.cssSelector("#loginpage-input-email"));
        WebElement passwordField = driver.findElement(By.cssSelector("#loginpage-form-pw-input"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@type='submit']"));

        confirmBtn.click();
        emailField.sendKeys(ConfigurationReader.get("userTeacher"));
        passwordField.sendKeys("wrongPassword");
        loginBtn.click();

        WebElement warningMessage = driver.findElement(By.cssSelector(".alert.alert-danger"));

        // assert warning message is displayed
        Assert.assertTrue(warningMessage.isDisplayed(),"Verifying warning message is displayed upon invalid login");

        // assert warning message = "Invalid Credentials!"
        Assert.assertEquals(warningMessage.getText(),"Invalid Credentials!", "Verifying warning message = \"Invalid Credentials!\" ");

    }
    @Test
    public void wrongPassword_FromLoginPage() {

        driver.get(ConfigurationReader.get("url"));

        loginPage.iUnderstandButton.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("userTeacher"));
        loginPage.passwordInput.sendKeys("userPassword");
        loginPage.loginButton.click();

        // assert warning message is displayed
        Assert.assertTrue(loginPage.warningMessage.isDisplayed(),"Verifying warning message is displayed upon invalid login");
        // assert warning message = "Invalid Credentials!"
        Assert.assertEquals(loginPage.warningMessage.getText(),"Invalid Credentials!", "Verifying warning message = \"Invalid Credentials!\" ");

    }
    @Test
    public void wrongUserName_FromLoginPage() {

        driver.get(ConfigurationReader.get("url"));

        loginPage.iUnderstandButton.click();
        loginPage.usernameInput.sendKeys("invalidusername@gmail.com");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("userPassword"));
        loginPage.loginButton.click();


        // assert warning message is displayed
        Assert.assertTrue(loginPage.warningMessage.isDisplayed(),"Verifying warning message is displayed upon invalid login");
        // assert warning message = "Invalid Credentials!"
        Assert.assertEquals(loginPage.warningMessage.getText(),"Invalid Credentials!", "Verifying warning message = \"Invalid Credentials!\" ");

    }

}
