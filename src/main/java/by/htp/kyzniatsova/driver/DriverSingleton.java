package by.htp.kyzniatsova.driver;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import by.htp.kyzniatsova.util.ManagerProperties;

public class DriverSingleton {

	private static WebDriver driver;
    private static final Logger logger = LogManager.getRootLogger();
    private static final String WEBDRIVER_CHROME = ManagerProperties.getDriver();
    private static final String CHROME_PATH = ManagerProperties.getPath();
    
    private DriverSingleton(){};


    public static WebDriver getDriver(){
        if (null == driver){
            System.setProperty(WEBDRIVER_CHROME, CHROME_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
            logger.info("Browser started");
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

}
