package BasePages;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import Utilities.ReadingPropertiesFile;

public class MainPage {
	
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;
    

    @BeforeSuite
    public void inintializeSetup() {

    }

    @BeforeMethod
    public void openApplicationUrl(Method method) throws InterruptedException {

        String browser = ReadingPropertiesFile.getProperty("browser");
        String mode = ReadingPropertiesFile.getProperty("mode");
        String chromebrowser = ReadingPropertiesFile.getProperty("chrome_path");
        String firefoxbrowser = ReadingPropertiesFile.getProperty("firefox_path");
        String edgebrowser = ReadingPropertiesFile.getProperty("edge_path");

        // driver code to run the browser
        if (mode.equals("non-headless")) {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", chromebrowser);
                driver = new ChromeDriver();
            } else if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", firefoxbrowser);
                driver = new FirefoxDriver();
            } else if (browser.equals("edge")) {
                System.setProperty("webdriver.edge.driver", edgebrowser);
                driver = new EdgeDriver();
            } else
                System.out.println("browser name is invalid");

        } else if (mode.equals("headless")) {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", chromebrowser);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver(options);
            } else if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", firefoxbrowser);
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("headless");
                driver = new FirefoxDriver(options);
            } else if (browser.equals("edge")) {
                System.setProperty("webdriver.edge.driver", edgebrowser);
                EdgeOptions options = new EdgeOptions();
 //               options.addArguments("headless");
                driver = new EdgeDriver(options);
            } else
                System.out.println("browser name is invalid");
        }
        driver.manage().window().maximize();
        
        // Go To The Application URL
        driver.get(ReadingPropertiesFile.getProperty("url"));
        
        // Set the implicit wait time to 10 seconds
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        
        // Locate the button using its class
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Locate the button using its class
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(Common.confirmation_btn));

        // Click the button to confirm
        confirmButton.click();
        
        
        
    }  
    @AfterMethod
    public void tearDown(ITestResult result) {
        // Perform any necessary cleanup, logging, or reporting

        // Close the browser after each test method
        if (driver != null) {
            driver.quit();
        }
    }
}

