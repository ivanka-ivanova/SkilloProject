package Project.Tests;

import Project.Pages.BasePage;
import Project.Pages.HeaderPage;
import Project.Pages.LoginPage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest(){
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
        System.out.println("3. User is logged in");
        headerPage.addTextSearch("auto_user");
        headerPage.clickSearchButton();


    }
}
