package Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ShortWebVersion {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://training.skillo-bg.com:4200/posts/all");

        WebElement loginElement = driver.findElement(By.id("nav-link-login"));
        loginElement.click();
        System.out.println(loginElement.getText());
        driver.close();

    }
}
