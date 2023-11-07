package Project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    final String LOGIN_URL = "http://training.skillo-bg.com:4200/users/login";
    @FindBy (css = "app-login form")
    private WebElement loginForm;

    @FindBy(id = "defaultLoginFormUsername")
    private WebElement usernameField;

    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordField;

    @FindBy (className = "remember-me-button")
    private WebElement rememberMeButton;

    @FindBy(id="sign-in-button")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addUsername(String username) {
        fillInFields(usernameField, username);
    }

    public void addPassword(String password) {
       fillInFields(passwordField, password);
    }

    public void clickSignIn(){
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public void verifyUrl(){
        wait.until(ExpectedConditions.urlToBe(LOGIN_URL));
    }

}

