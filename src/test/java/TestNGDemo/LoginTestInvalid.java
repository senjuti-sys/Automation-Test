package TestNGDemo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestInvalid {

    @Test(description = "Invalid Test Data/Case")
    public void testCase_003(){
        System.out.println("Test case 3 Executed.");
    }
    @Test(description = "Invalid Test Data/Case")
    public void testCase_004(){
        System.out.println("Test case 4 Executed.");
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
