package DataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

//Single Data Provider in This class
//Only Invalid Login Test

public class DP_LoginTest {
    public static WebDriver driver;

    @BeforeClass
    @Parameters("BrowserName")
    public static void browser_config(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/index.php?route=account/login");
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            driver.get("https://demo.opencart.com/index.php?route=account/login");
        }
        else if(browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/index.php?route=account/login");
        }
        else {
            System.out.println("PLease Enter Valid Browser name");
        }
    }

    @AfterClass
    public static void close_browser(){
        driver.close();
    }

    @Test(dataProvider = "LoginData_Invalid")
    public static void login_invalid_TC_002(String DP_Email,String DP_Pass){

        WebElement Email= driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys(DP_Email);

        WebElement Pass= driver.findElement(By.id("input-password"));
        Pass.clear();
        Pass.sendKeys(DP_Pass);

        WebElement LoginBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();

        String ExpectedTitle="Account Login";
        String ActualTitle= driver.getTitle();

        if(ExpectedTitle.equals(ActualTitle)){
            System.out.println("Title Verification Passed");
        }
        else
            System.out.println("Title Verification Failed !!! "+"Actual Title is: "+ActualTitle);
    }

    @DataProvider(name = "LoginData_Invalid")
    public Object [][] data(){
        Object [][] data=new Object[3][2];

        //Data set 1
        data [0][0]="invalidMail1@mail";
        data [0][1]="1232321";

        //Data set 2
        data [1][0]="invalidMail2@mail";
        data [1][1]="231133";

        //Data set 3
        data [2][0]="invalidMail3@mail";
        data [2][1]="123123123";

        return data;
    }
}
