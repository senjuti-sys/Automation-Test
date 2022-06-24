package com.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class BaseClass {
   public static WebDriver driver;

   public static String Firefox="Firefox";
   public static String Chrome="Chrome";

    //Chrome
    public static void chrome_launch(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void chrome_close(){
        if(driver!=null){
            driver.close();
        }
        else {
            System.out.println("Nothing to Close. No Browser found.");
        }

    }
    public static void chrome_quit(){driver.quit();}

    //Firefox
    public static void firefox_launch(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/Drivers/geckodriver.exe");
        driver=new FirefoxDriver();
    }
    public static void firefox_close(){
        driver.close();
    }
    public static void firefox_quit(){
        driver.quit();
    }

    public static WebDriver launchBrowser(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("safari")){
            WebDriverManager.safaridriver().setup();
            driver=new SafariDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver().setup();
            driver=new EdgeDriver();
        }
        else {
            System.out.println("Please Enter valid browser....");
        }
        return driver;
    }
    public static void closeBrowser(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            if(driver!=null){
                driver.close();
            }
            else {
                System.out.println("Nothing to Close. No Browser found.");
            }
        }
        else if(browser.equalsIgnoreCase("firefox")){
            if(driver!=null){
                driver.close();
            }
            else {
                System.out.println("Nothing to Close. No Browser found.");
            }
        }
        else if(browser.equalsIgnoreCase("safari")){
            if(driver!=null){
                driver.close();
            }
            else {
                System.out.println("Nothing to Close. No Browser found.");
            }
        }
        else if(browser.equalsIgnoreCase("edge")){
            if(driver!=null){
                driver.close();
            }
            else {
                System.out.println("Nothing to Close. No Browser found.");
            }
        }
        else {
            System.out.println("Please Enter valid browser to close....");
        }

    }
    public static void quitBrowser(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            if(driver!=null){
                driver.quit();
            }
            else {
                System.out.println("Nothing to Close. No Browser found.");
            }
        }
        else if(browser.equalsIgnoreCase("firefox")){
            if(driver!=null){
                driver.quit();
            }
            else {
                System.out.println("Nothing to Close. No Browser found.");
            }
        }
        else if(browser.equalsIgnoreCase("safari")){
            if(driver!=null){
                driver.quit();
            }
            else {
                System.out.println("Nothing to Close. No Browser found.");
            }
        }
        else if(browser.equalsIgnoreCase("edge")){
            if(driver!=null){
                driver.quit();
            }
            else {
                System.out.println("Nothing to Close. No Browser found.");
            }
        }
        else {
            System.out.println("Please Enter valid browser to close....");
        }

    }
    public static void open_URL(String url){
        if(url==null){
            System.out.println("URL is NULL!!!!");
        }
        if(url.indexOf("http")==-1){
            System.out.println("http is missing..");
        }
        driver.get(url);
    }

    //Click on Element
    public static void clickOnElementBy_ID(String id){
        driver.findElement(By.id(id)).click();
    }
    public static void clickOnElementBy_Name(String Name){
        driver.findElement(By.name(Name)).click();
    }
    public static void clickOnElementBy_Xpath(String Xpath){
        driver.findElement(By.xpath(Xpath)).click();
    }
    public static void clickOnElementBy_Css(String Css){
        driver.findElement(By.cssSelector(Css)).click();
    }
    public static void clickOnElementByLinkText(String LinkText){
        driver.findElement(By.linkText(LinkText)).click();
    }

    //Clear Text filed
    public static void clearTextFieldByID(String id){
        driver.findElement(By.id(id)).clear();
    }
    public static void clearTextFieldByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).clear();
    }
    public static void clearTextFieldByName(String name){
        driver.findElement(By.name(name)).clear();
    }
    public static void clearTextFieldByCss(String css){
        driver.findElement(By.cssSelector(css)).clear();
    }

    //Type on Element
    public static void typeOnElementBy_ID(String id, String value){
        driver.findElement(By.id(id)).sendKeys(value);
    }
    public static void typeOnElementBy_Name(String Name,String value){
        driver.findElement(By.name(Name)).sendKeys(value);
    }
    public static void typeOnElementBy_Xpath(String Xpath,String value){
        driver.findElement(By.xpath(Xpath)).sendKeys(value);
    }
    public static void typeOnElementBy_Css(String Css,String value){
        driver.findElement(By.cssSelector(Css)).sendKeys(value);
    }

    //Alert
    public static void alertAccept(){
    driver.switchTo().alert().accept();
    }
    public static void alertCancel(){
        driver.switchTo().alert().dismiss();
    }
    public static void typeOnAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    //Wait
    public static void smallWait() throws InterruptedException {
        Thread.sleep(3000);
    }
    public static void midWait() throws InterruptedException {
        Thread.sleep(7000);
    }
    public static void longWait() throws InterruptedException {
        Thread.sleep(10000);
    }
    public static void customWait(int MileSeconds) throws InterruptedException {
        Thread.sleep(MileSeconds);
    }

    //Screenshots
    public static void getVisiblePartScreenshot(String name) throws IOException {
        //Screenshot Capture
        File screenshotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Store Image
        FileUtils.copyFile(screenshotFile,new File("./src/main/ScreenshotImages/"+name+".png"),true);
    }
    public static void getFullPageScreenshot(String name) throws IOException {
        //Screenshot Capture
        Screenshot entirePage=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

        //Store Image
        ImageIO.write(entirePage.getImage(),"PNG",new File("./src/main/ScreenshotImages/"+name+".png"));
    }
    public static void getElementScreenshot(String name) throws IOException {
        WebElement SearchBox= driver.findElement(By.name("search"));
        //Screenshot Capture
        File screenshotFile= ((TakesScreenshot)SearchBox).getScreenshotAs(OutputType.FILE);
        //Store Image
        FileUtils.copyFile(screenshotFile,new File("./src/main/ScreenshotImages/"+name+".png"),true);
    }
    public static void getHighlightElementScreenshot(String name) throws IOException {
        WebElement SearchBox= driver.findElement(By.name("search"));

        JavascriptExecutor jse=(JavascriptExecutor)driver;

        //Highlight Element with Red border 5px
        jse.executeScript("arguments[0].style.border='5px solid red' ",SearchBox);

        //Screenshot Capture
        File screenshotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Store Image
        FileUtils.copyFile(screenshotFile,new File("./src/main/ScreenshotImages/HighlightSearchBox.jpeg"),true);
    }

}
