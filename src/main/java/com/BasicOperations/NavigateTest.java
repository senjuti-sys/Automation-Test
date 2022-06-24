package com.BasicOperations;

import com.Base.BaseClass;

public class NavigateTest extends BaseClass {
    public static void main(String[] args) {
        chrome_launch();
        open_URL("https://google.com");
        navigateTo();
        navigateBack();
        navigateForward();
        chrome_close();
    }
    public static void navigateTo(){
        driver.navigate().to("https://demo.opencart.com/");
        TitleURL.title_verification("Your Store");
    }
    public static void navigateBack(){
        driver.navigate().back();
        TitleURL.title_verification("Google");
    }
    public static void navigateForward(){
        driver.navigate().forward();
        TitleURL.title_verification("Your Store");
    }

}
