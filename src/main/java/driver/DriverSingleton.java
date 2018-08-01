package driver;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.ManagerProperties;

public class DriverSingleton {
//	private static ManagerProperties manager;
	private static WebDriver driver;
    private static final Logger logger = LogManager.getRootLogger();
//    private static final String WEBDRIVER_CHROME = manager.wb_d;
//    private static final String CHROME_PATH = manager.wb_p;
    private static final String WEBDRIVER_CHROME = "webdriver.chrome.driver";
    private static final String CHROME_PATH = "C:\\Program Files\\chromedriver.exe";
    
    private DriverSingleton(){};


    public static WebDriver getDriver(){
        if (null == driver){
            System.setProperty(WEBDRIVER_CHROME, CHROME_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//            driver.manage().window().maximize();
            logger.info("Browser started");
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

}
