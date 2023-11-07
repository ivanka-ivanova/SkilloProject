package Project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;


public class NewPostPage extends BasePage{
    private String POST_URL = "http://training.skillo-bg.com:4200/posts/create";
    @FindBy(css = "input[type ='file']")
    WebElement fileInput;

    @FindBy(className = ".image-preview")
    WebElement imagePreview;

    @FindBy(css = ".input-group input")
    WebElement imageTitle;

    @FindBy (id = "create-post")
    WebElement submitButton;

    @FindBy (css = "input[name='caption']")
    WebElement captionField;

    public NewPostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void uploadFile(File file){
    fileInput.sendKeys(file.getAbsolutePath());
    }

    public void verifyUrl(){
        wait.until(ExpectedConditions.urlToBe(POST_URL));
    }

    public String checkImgTitle(){
        return imageTitle.getAttribute("placeholder");
    }

    public void verifyImage(){
        wait.until(ExpectedConditions.visibilityOf(imagePreview));
    }

    public void clickSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
       submitButton.click();
    }

    public void addCaption(String text){
        captionField.sendKeys(text);
    }


}
