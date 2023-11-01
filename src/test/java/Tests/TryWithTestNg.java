package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TryWithTestNg {


    private static WebDriver driver;

    @BeforeMethod
    private static void setUpDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
     @Test
     private static void test(){
         driver.get("http://training.skillo-bg.com:4200/posts/all");
         WebElement loginElement = driver.findElement(By.id("nav-link-login"));
         loginElement.click() ;
         String loginUrl = "http://training.skillo-bg.com:4200/users/login";
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
         wait.until(ExpectedConditions.urlToBe(loginUrl));

         //driver.get("http://training.skillo-bg.com:4200/users/login");
         WebElement userName = driver.findElement(By.name("usernameOrEmail"));
         userName.sendKeys("Test_Iv");
         WebElement password = driver.findElement(By.id("defaultLoginFormPassword"));
         password.sendKeys("Test1!");
         WebElement signInButton = driver.findElement(By.id("sign-in-button"));
         signInButton.click();

     }

    @AfterMethod
    private static void cleanUp(){
        driver.close();
    }
}
