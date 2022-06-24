package com.BasicOperations;

import com.Base.BaseClass;
import org.openqa.selenium.Dimension;

public class BrowserSize extends BaseClass {
    public static void main(String[] args) {
        chrome_launch();
        getMaximizeWindowSize();
        setWindowSize(1000,600);
        chrome_close();
    }
    public static void getMaximizeWindowSize(){
     int max_Width=driver.manage().window().getSize().getWidth();
     int max_Height=driver.manage().window().getSize().getHeight();
     System.out.println("Maximize Window Width: "+max_Width+" Height "+max_Height);
    }
    public static void setWindowSize(int Width,int Height){
        driver.manage().window().setSize(new Dimension(Width,Height));
    }

}
