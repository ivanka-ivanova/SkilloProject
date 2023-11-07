package Project.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HeaderPage extends BasePage {
    private String HOME_URL = "http://training.skillo-bg.com:4200/posts/all";
    @FindBy(id = "nav-link-home")
    private WebElement homeButton;

    @FindBy (id = "nav-link-login")
    private WebElement loginButton;

    @FindBy (id = "nav-link-profile")
    private WebElement profileButton;

    @FindBy (id = "nav-link-new-post")
    private WebElement newPostButton;

    @FindBy (id = "search-bar")
    private WebElement searchBar;

    @FindBy(css = ".fa-seacrh")
    private WebElement searchButton;

    @FindBy(css = "app-all-posts")
    List<WebElement> allPosts;

    @FindBy(css = "input[placeholder='Comment here']")
    WebElement commentField;

    @FindBy (css = "app-comment-list")
    List<WebElement> allComments;

    @FindBy (css = "app-comment")
    WebElement comment;

    public void clickHomeButton(){
        clickElement(homeButton);
    }

    public void clickLoginButton(){
        clickElement(loginButton);
    }

    public void clickProfileButton (){
        clickElement(profileButton);
    }


    public void clickNewPost(){
        clickElement(newPostButton);
    };

    public void clickSearchBar(){
        clickElement(searchBar);
    }
    public void clickSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        clickElement(searchButton);
    }

    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void typeInSeacrhField(String text){
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(text);
    }
    public void verifyUrl(){
        wait.until(ExpectedConditions.urlToBe(HOME_URL));
    }

    public void addTextSearch(String text){
        fillInFields(searchBar, text);
    }

    public int getAllPosts(){
        wait.until(ExpectedConditions.visibilityOf(allPosts.get(0)));
        return allPosts.size();
    }

    public void openFirstPost(int  index){
        clickElement(allPosts.get(index));
    }


    public int getAllComments(){
        wait.until(ExpectedConditions.visibilityOf(allComments.get(0)));
        return allComments.size();
    }
    public void addComment(String text){
        wait.until(ExpectedConditions.visibilityOf(commentField));
        commentField.sendKeys(text);
        commentField.sendKeys(Keys.RETURN);
    }
}
