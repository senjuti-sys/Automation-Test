package AbcBank.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class ABCLoginTest {
   public static WebDriver driver;

   @BeforeMethod
    public void init_setup(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("http://demo.guru99.com/v4/");
    }

    @AfterMethod
    public void tear_Down(){
        driver.close();
    }

    @Test()
    public void login_TC003(){
        WebElement userID= driver.findElement(By.name("uid"));
        userID.clear();
        userID.sendKeys("mngr368363");

        WebElement password= driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("34J6A!");

        WebElement loginBtn=driver.findElement(By.name("btnLogin"));
        loginBtn.click();
    }

    @Test()
    public void login_TC001(){
        WebElement userID= driver.findElement(By.name("uid"));
        userID.clear();
        userID.sendKeys("");

        WebElement password= driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("");

        WebElement loginBtn=driver.findElement(By.name("btnLogin"));
        loginBtn.click();

        driver.switchTo().alert().accept();
    }
    @Test()
    public void login_TC002(){
        WebElement userID= driver.findElement(By.name("uid"));
        userID.clear();
        userID.sendKeys("");

        WebElement password= driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("");

        WebElement loginBtn=driver.findElement(By.name("btnLogin"));
        loginBtn.click();

        driver.switchTo().alert().accept();
    }


}
