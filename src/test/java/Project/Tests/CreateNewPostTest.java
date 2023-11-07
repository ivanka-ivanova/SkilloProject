package Project.Tests;

import Project.Pages.HeaderPage;
import Project.Pages.LoginPage;
import Project.Pages.NewPostPage;
import Project.Pages.ProfilePage;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.File;

public class CreateNewPostTest extends BaseTest{

@Test
public void createNewPostTest(){
    HeaderPage headerPage = new HeaderPage(driver);
    driver.get("http://training.skillo-bg.com:4200/posts/all");
    headerPage.clickLoginButton();
    LoginPage loginPage = new LoginPage(driver);
    loginPage.addUsername("Test_Iv");
    loginPage.addPassword("Test1!");
    loginPage.clickSignIn();
    System.out.println("1. User is logged in");
    headerPage.clickNewPost();
    NewPostPage newPost = new NewPostPage(driver);
    File file = new File("C:\\Users\\PC\\IdeaProjects\\Skillo Project\\src\\test\\resources\\Pictures\\Bug1.jpg\\");
    newPost.uploadFile(file);
    newPost.checkImgTitle();
    String expectedImgTitle = "Bug1.jpg";
    Assert.assertEquals(expectedImgTitle, newPost.checkImgTitle(), "Titles don't match");
    System.out.println("Titles match, the title is: " + newPost.checkImgTitle());
    newPost.addCaption("My first post!");
    System.out.println("Caption was added");
    newPost.clickSubmitButton();
    ProfilePage profile = new ProfilePage(driver);
    profile.checkUrl();
    int existingPosts = profile.getExistingPost();
    System.out.println(existingPosts);
    int allPosts = profile.getAllPostsCount();
    System.out.println(allPosts);
    System.out.println("A new post count was created");
    profile.openFirstPost(0);
    profile.verifyPostCanBeOpened();
    System.out.println("The First post is opened");

    }

}
