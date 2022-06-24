package com.BasicOperations;

import com.Base.BaseClass;

import java.io.IOException;

public class TitleURL extends BaseClass {
    public static void main(String[] args) throws IOException {
        firefox_launch();
        open_URL("https://google.com");
        title_verification("Your Store");
        url_verification("https://demo.opencart.com");
        firefox_close();
    }
    public static void title_verification(String ExpectedTitle){
      //  String ExpectedTitle="My Store";
        String ActualTitle= driver.getTitle();

     if(ExpectedTitle.equals(ActualTitle)){
         System.out.println("Title Verification Passed");
     }
     else
         System.out.println("Title Verification Failed !!! "+"Actual Title is: "+ActualTitle);
    }
    public static void url_verification(String ExpectedUrl){
        String ActualUrl= driver.getCurrentUrl();

        if(ExpectedUrl.equals(ActualUrl)){
            System.out.println("Url Verification Passed");
        }
        else
            System.out.println("Url Verification Failed !!! "+"Actual Url is: "+ActualUrl);
    }


}

