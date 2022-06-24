package TestNGDemo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestValid {

    @Test(description = "Valid Test Data/Case")
    public void testCase_001(){
        System.out.println("Test case 1 Executed.");
    }

    @Test(description = "Valid Test Data/Case")
    public void testCase_002(){
        System.out.println("Test case 2 Executed.");
    }

    @BeforeTest
    public static void BrowserLaunch(){
        System.out.println("Browser Lunch Successful.");
    }
    @AfterTest
    public static void BrowserClose(){
        System.out.println("Browser Close Successful.");
    }
}
