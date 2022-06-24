package com.BasicOperations;

import com.Base.BaseClass;

public class BasicAuth extends BaseClass {
    public static void main(String[] args) {
        launchBrowser(Firefox);
        basicAuthTest();
        closeBrowser(Firefox);
    }
    public static void basicAuthTest(){
        //formula --> protocols://username:password@url
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        System.out.println(driver.getTitle());
    }
}
