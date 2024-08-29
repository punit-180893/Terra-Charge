package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
    public static void takeScreenShots(WebDriver driver,String fileName) throws IOException {
        String screenshotFileName = System.getProperty("user.dir")+ "\\" + fileName+".jpg";
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{

            FileUtils.copyFile(srcFile,new File(screenshotFileName));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}
