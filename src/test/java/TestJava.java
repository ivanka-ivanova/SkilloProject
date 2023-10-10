import org.junit.Test;
import org.testng.annotations.BeforeTest;

public class TestJava {
    @BeforeTest
    public void BeforeCheck() {
        System.out.println("Check if it will be printed before each test");
    }
    @Test
    public void FirstMethod(){
        System.out.println("Print First Method");

    }
    @Test
    public void SecondMethod(){
        System.out.println("Print Second Method");

    }
}
