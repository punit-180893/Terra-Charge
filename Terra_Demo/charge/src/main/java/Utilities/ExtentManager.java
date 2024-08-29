package Utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
    private static ExtentReports extent;

    public static ExtentReports getInstance(String filename){
        if(extent==null){
            extent=new ExtentReports(filename,true, DisplayOrder.NEWEST_FIRST);
            extent.loadConfig(new File(System.getProperty("user.dir") + "//reportConfig.xml"));
            extent.addSystemInfo("Selenium version","4.1.3").addSystemInfo("Environment","QA");
        }
        return extent;
    }


}
