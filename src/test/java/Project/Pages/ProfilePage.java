package Project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ProfilePage extends BasePage {

    final private String PROFILE_URL = "http://training.skillo-bg.com:4200/users/5028";

    @FindBy(css = ".fa-user-edit")
    WebElement editUserButton;

    @FindBy(xpath = "//li[contains(text(), 'posts')]/strong")
    WebElement countPosts;

    @FindBy(css ="app-post")
    List<WebElement> existingPosts;

    @FindBy(css = ".modal-content")
    WebElement postForm;

    @FindBy (css = ".fa-user-edit")
    WebElement editButton;

    @FindBy (css = "app-edit-profile-modal")
    WebElement editForm;

    @FindBy (css = "input[formcontrolname='username']")
    WebElement userNameField;

    @FindBy (css = "input[formcontrolname='email]")
    WebElement emailField;

    @FindBy (css = "input[formcontrolname='password']")
    WebElement passwordField;
    @FindBy (css = "input[formcontrolname='confirmPassword']")
    WebElement confirmPasswordField;
    @FindBy (css = "input[formcontrolname='publicInfo']")
    WebElement publicInfoField;

    @FindBy (css = "input[type='submit']")
    WebElement saveButton;



    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void checkUrl(){
        wait.until(ExpectedConditions.urlToBe(PROFILE_URL));
    }

    public int getAllPostsCount (){
        wait.until(ExpectedConditions.visibilityOf(countPosts));
        return Integer.parseInt(countPosts.getText());
    }

    public int getExistingPost() {
        wait.until(ExpectedConditions.visibilityOf(existingPosts.get(0)));
        return existingPosts.size();

    }
    public void openFirstPost(int index){
        clickElement(existingPosts.get(index));
    }

    public void verifyPostCanBeOpened(){
    wait.until(ExpectedConditions.visibilityOf(postForm));
    }

    public void clickEditButton(){
        wait.until(ExpectedConditions.visibilityOf(editUserButton));
        clickElement(editUserButton);
    }

    public void clickUserNameField(){
        clickElement(userNameField);
    }

    public void clickEmailField(){
        clickElement(emailField);
    }
    public void clickPasswordField(){
        clickElement(passwordField);
    }

    public void clickConfirmPasswordField(){
        clickElement(confirmPasswordField);
    }

    public void clickPublicInfoField(){
        clickElement(publicInfoField);
    }

    public void clickSaveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        clickElement(saveButton);
    }



    public void verifyEditForm (){
        wait.until(ExpectedConditions.visibilityOf(editForm));
    }

    public void checkValidation(WebElement element){
        String classAttribute = element.getAttribute("class");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(classAttribute.contains("id-valid"), "Not valid input");
        softAssert.assertAll();

    }

    public void checkUserName(){
        checkValidation(userNameField);
    }
    public void checkEmail(){
        checkValidation(emailField);
    }
    public void checkPassword(){
        checkValidation(passwordField);
    }

    public void checkConfirmPassword(){
        checkValidation(confirmPasswordField);
    }

    public void checkPublicInfo(){
        checkValidation(publicInfoField);
    }

    public void editPublicInfoField (String text){
        publicInfoField.sendKeys(text);
    }
    public void editUser(String text){
        userNameField.sendKeys(text);
    }
    public void editEmail(String text){
        emailField.sendKeys(text);
    }
    public void editPassword(String text){
        passwordField.sendKeys(text);
    }
    public void editConfirmPassword(String text){
        confirmPasswordField.sendKeys(text);
    }

    public void checkNewAmendment(){
        String newInfo = "The edit is working";
        String postInfo = publicInfoField.getText();
        Assert.assertEquals(newInfo, postInfo, "The new info is not saved");

    }
}


