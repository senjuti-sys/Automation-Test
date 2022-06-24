package com.BasicOperations;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Locator extends BaseClass {
    public static void main(String[] args) {
        chrome_launch();
        open_URL("https://demo.opencart.com/index.php?route=account/login");
       // locator_ID();
      //  locator_Name();
      //  locator_Xpath();
        locator_Css();
    }
    public static void locator_ID(){
        WebElement Email= driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("test@testmail.com");
    }
    public static void locator_Name(){
        WebElement Email= driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys("test@mail.com");
    }
    public static void locator_Xpath(){
        WebElement Email= driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
        Email.clear();
        Email.sendKeys("xpath@mail.com");
    }
    public static void locator_Css(){
        WebElement Email= driver.findElement(By.cssSelector("#input-email"));
        Email.clear();
        Email.sendKeys("css@mail.com");
    }
}
