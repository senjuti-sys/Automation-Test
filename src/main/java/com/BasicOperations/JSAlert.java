package com.BasicOperations;

import com.Base.BaseClass;

public class JSAlert extends BaseClass {
    public static String TestBrowser="Chrome";
    public static void main(String[] args) throws InterruptedException {
        launchBrowser(TestBrowser);
        open_URL("https://the-internet.herokuapp.com/javascript_alerts");
        normalAlert();
        confirmAlert();
        promptAlert();
        closeBrowser(TestBrowser);
    }
    public static void normalAlert(){
        clickOnElementBy_Xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
        alertAccept(); //Click on OK
    }
    public static void confirmAlert(){
        clickOnElementBy_Xpath("//*[@id=\"content\"]/div/ul/li[2]/button");
        alertCancel(); // Click on Cancel
    }
    public static void promptAlert() throws InterruptedException {
        clickOnElementBy_Xpath("//*[@id=\"content\"]/div/ul/li[3]/button");
        typeOnAlert("Selenium WebDriver");
        customWait(2000);
        alertAccept();
    }
}
