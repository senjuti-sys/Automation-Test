package com.BasicOperations;

import com.Base.BaseClass;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindow extends BaseClass {
    public static String TestBrowser="Chrome";

    public static void main(String[] args) {
        launchBrowser(TestBrowser);
        open_URL("https://the-internet.herokuapp.com/windows");
        clickOnElementByLinkText("Click Here");
        switchTab();
        quitBrowser(TestBrowser);
    }
    public static void switchTab(){
        Set<String> tabNumber= driver.getWindowHandles();
        Iterator<String> it=tabNumber.iterator();

        String parentWindow= it.next();
        String childWindow=it.next();

        //Switching to parent
        driver.switchTo().window(parentWindow);
        open_URL("https://google.com");
        System.out.println("Parent Window Title: "+driver.getTitle());

        //Switching to child
        driver.switchTo().window(childWindow);
        open_URL("https://bbc.com");
        System.out.println("Child Window Title: "+driver.getTitle());

    }
}
