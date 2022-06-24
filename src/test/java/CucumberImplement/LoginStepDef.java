package CucumberImplement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginStepDef {
    WebDriver driver;

    @Given("Open browser and navigate to Login page")
    public void open_browser_and_navigate_to_login_page() {
        System.setProperty("webdriver.gecko.driver","./src/main/resources/Drivers/geckodriver.exe");
        driver=new FirefoxDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }
    @When("Enter Email and Password")
    public void enter_email_and_password() {
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("user101asdsa@gmail.comdasasd");

        WebElement Pass = driver.findElement(By.id("input-password"));
        Pass.clear();
        Pass.sendKeys("123456");

        WebElement LoginBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();

        String ExpectedTitle = "Account Login";
        String ActualTitle = driver.getTitle();

        if (ExpectedTitle.equals(ActualTitle)) {
            System.out.println("Title Verification Passed");
        } else {
            System.out.println("Title Verification Failed !!! " + "Actual Title is: " + ActualTitle);
        }

    }
    @Then("Login Unsuccessful and close test")
    public void login_unsuccessful_and_close_test() {
        driver.close();
    }
}
