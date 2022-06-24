package com.BasicOperations;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class Frames extends BaseClass {

    public static void main(String[] args) {
        launchBrowser("firefox");
        open_URL("https://the-internet.herokuapp.com/iframe");
        iFrame();
    }
    public static void iFrame(){
        driver.switchTo().frame("mce_0_ifr");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement frameBody=driver.findElement(By.id("tinymce"));
        frameBody.clear();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        frameBody.sendKeys("Test Automation");
    }
}
