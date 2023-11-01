package Tests;

import org.openqa.selenium.chrome.ChromeDriver;

public class webClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\IdeaProjects\\Skillo Project\\src\\test\\resources\\drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://training.skillo-bg.com:4200/users/login");
        driver.manage().window().maximize();
        driver.close();

    }
}
