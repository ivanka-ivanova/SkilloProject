package Project.Tests;

import Project.Pages.HeaderPage;
import Project.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommentPostTest extends BaseTest {

    @Test
    public void commentPost(){
    HeaderPage headerPage = new HeaderPage(driver);
    driver.get("http://training.skillo-bg.com:4200/posts/all");
    headerPage.clickLoginButton();
    LoginPage loginPage = new LoginPage(driver);
    loginPage.addUsername("Test_Iv");
    loginPage.addPassword("Test1!");
    loginPage.clickSignIn();
    System.out.println("1. User is logged in");
    HeaderPage headerpage = new HeaderPage(driver);
    headerpage.getAllPosts();
    headerpage.openFirstPost(0);
    headerpage.addComment("Comment a post");
    System.out.println("2. A comment has been successfully posted");
    
}
}