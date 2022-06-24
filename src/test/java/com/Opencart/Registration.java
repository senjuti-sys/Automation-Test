package com.Opencart;

import Base.BaseClassTest;


public class Registration extends BaseClassTest {
    public static void main(String[] args) {
        String Browser="firefox";
        launchBrowser(Browser);
        open_URL("https://demo.opencart.com/index.php?route=account/register");
        Registration_TC_001();

    }
    //Valid
    public static void Registration_TC_001(){
        String Email="newuser2@mailbd.com";
        String Pass="123456";

        //First Name
        clearTextFieldByID("input-firstname");
        typeOnElementBy_ID("input-firstname","Muntasir");

        //Last Name
        clearTextFieldByID("input-lastname");
        typeOnElementBy_ID("input-lastname","Abdullah");

        //Email
        clearTextFieldByID("input-email");
        typeOnElementBy_ID("input-email",Email);

        //Telephone
        clearTextFieldByID("input-telephone");
        typeOnElementBy_ID("input-telephone","123456789");

        //Password
        clearTextFieldByID("input-password");
        typeOnElementBy_ID("input-password",Pass);

        //Confirm Password
        clearTextFieldByID("input-confirm");
        typeOnElementBy_ID("input-confirm",Pass);

        //privacy policy
        clickOnElementBy_Xpath("//*[@id=\"content\"]/form/div/div/input[1]");

        //Continue
        clickOnElementBy_Xpath("//*[@id=\"content\"]/form/div/div/input[2]");

    }
}
