package CrossBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CB_LoginTest {

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

    @Test(description = "Email and Pass are valid")
    public static void login_valid_TC_001() {

        WebElement Email = driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("user101@gmail.com");

        WebElement Pass = driver.findElement(By.id("input-password"));
        Pass.clear();
        Pass.sendKeys("123456");

        WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();

        String ExpectedTitle = "My Account";
        String ActualTitle = driver.getTitle();

        if (ExpectedTitle.equals(ActualTitle)) {
            System.out.println("Title Verification Passed");
        } else {
            System.out.println("Title Verification Failed !!! " + "Actual Title is: " + ActualTitle);
        }
        driver.findElement(By.linkText("Logout")).click();
    }

 }

