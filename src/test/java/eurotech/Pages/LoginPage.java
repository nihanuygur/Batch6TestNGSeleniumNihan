package eurotech.Pages;

import eurotech.utilities.ConfigurationReader;
import eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "#rcc-confirm-button")
    public WebElement iUnderstandButton;

    @FindBy(name = "email")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(id = "loginpage-form-btn")
    public WebElement loginButton;

    @FindBy(xpath = "//div[text()='Invalid Credentials!']")
    public WebElement warningMessage;


    public void login(String userName, String password) {

        iUnderstandButton.click();
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    public void loginAsTeacher() {
        String userName = ConfigurationReader.get("userTeacher");
        String password = ConfigurationReader.get("userPassword");

        iUnderstandButton.click();
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    public void loginAsStudent() {
        String userName = ConfigurationReader.get("usernameStudent");
        String password = ConfigurationReader.get("passwordStudent");

        iUnderstandButton.click();
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }


}
