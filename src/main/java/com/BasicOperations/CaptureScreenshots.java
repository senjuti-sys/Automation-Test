package com.BasicOperations;

import com.Base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CaptureScreenshots extends BaseClass {
    public static void main(String[] args) throws IOException {
        launchBrowser(Chrome);
        open_URL("https://demo.opencart.com/");
      //  getVisiblePartScreenshot();
       // getFullPageScreenshot();
      //  getElementScreenshot();
        getHighlightElementScreenshot();
        closeBrowser(Chrome);
    }
    public static void getVisiblePartScreenshot() throws IOException {
        //Screenshot Capture
        File screenshotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Store Image
        FileUtils.copyFile(screenshotFile,new File("./src/main/ScreenshotImages/VisiblePart.png"),true);
    }

    public static void getFullPageScreenshot() throws IOException {
        //Screenshot Capture
        Screenshot entirePage=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

        //Store Image
        ImageIO.write(entirePage.getImage(),"PNG",new File("./src/main/ScreenshotImages/FullPage.png"));
    }
    public static void getElementScreenshot() throws IOException {
        WebElement SearchBox= driver.findElement(By.name("search"));
        //Screenshot Capture
        File screenshotFile= ((TakesScreenshot)SearchBox).getScreenshotAs(OutputType.FILE);
        //Store Image
        FileUtils.copyFile(screenshotFile,new File("./src/main/ScreenshotImages/SearchBox.jpeg"),true);
    }
    public static void getHighlightElementScreenshot() throws IOException {
        WebElement SearchBox= driver.findElement(By.name("search"));

        JavascriptExecutor jse=(JavascriptExecutor)driver;

        //Highlight Element with Red border 5px
        jse.executeScript("arguments[0].style.border='5px solid red' ",SearchBox);

        //Screenshot Capture
        File screenshotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Store Image
        FileUtils.copyFile(screenshotFile,new File("./src/main/ScreenshotImages/HighlightSearchBox.jpeg"),true);
    }
}
