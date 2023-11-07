package Project.Tests;

import Project.Pages.BasePage;
import Project.Pages.HeaderPage;
import Project.Pages.LoginPage;
import Project.Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditUser extends BaseTest {
    @Test
    public void editUser(){
        HeaderPage headerPage = new HeaderPage(driver);
        driver.get("http://training.skillo-bg.com:4200/posts/all");
        headerPage.verifyUrl();
        System.out.println("1. The site has been opened");
        headerPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyUrl();
        System.out.println("2. Login URL is correct");
        loginPage.addUsername("Test_Iv");
        loginPage.addPassword("Test1!");
        loginPage.clickSignIn();
        System.out.println("3. Successful log in");
        ProfilePage profile = new ProfilePage(driver);
        headerPage.clickProfileButton();
        profile.checkUrl();
        System.out.println("4. Profile page has been opened");
        profile.clickEditButton();
        profile.verifyEditForm();
        System.out.println("5. Edit form has been opened");
        profile.clickUserNameField();
        profile.checkUserName();
        profile.clickEmailField();


    }

}
