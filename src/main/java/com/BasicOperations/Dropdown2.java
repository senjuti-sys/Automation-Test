package com.BasicOperations;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown2 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("firefox");
        open_URL("https://the-internet.herokuapp.com/dropdown");
        customWait(5000);
        selectCountry();
    }
    public static void selectCountry() throws InterruptedException {
        WebElement options=driver.findElement(By.id("dropdown"));
        Select obj=new Select(options);
      //  obj.selectByVisibleText("Option 1");
        obj.selectByValue("2");

    }

}
