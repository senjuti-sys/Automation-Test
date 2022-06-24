package TestNGDemo;

import org.testng.annotations.*;

public class TestNGBasic {

    @Test(priority = -1)
    public void testCase_001(){
        System.out.println("Test case 1 Executed.");
    }

    @Test(priority = -1)
    public void testCase_002(){
        System.out.println("Test case 2 Executed.");
    }

    @Test(enabled = false)
    public void testCase_003(){
        System.out.println("Test case 3 Executed.");
    }
    @Test(description = "Invalid Test Data/Case")
    public void testCase_004(){
        System.out.println("Test case 3 Executed.");
    }

    @BeforeTest
    public static void BrowserLaunch(){
        System.out.println("Browser Lunch Successful.");
    }
    @AfterTest
    public static void BrowserClose(){
        System.out.println("Browser Close Successful.");
    }
    /*
    @BeforeMethod
    public static void OpenURL(){
        System.out.println("URL open Successful.");
    }
    @AfterMethod
    public static void TestClose(){
        System.out.println("Test Case Executed Successful.");
    }
     */

}
