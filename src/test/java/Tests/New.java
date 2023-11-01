package Tests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class New {
    @Test()
    public void FirstMethod(){
        System.out.println("Test");
    }

    @BeforeTest
    public void BeforeFirst(){
        System.out.println("Add something");
    }

}
