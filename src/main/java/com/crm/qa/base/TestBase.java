package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

        public static WebDriver driver;
        public static Properties prop;

        public TestBase()  {
            try {
                prop = new Properties();
                FileInputStream file = new FileInputStream("/Users/snehal/IdeaProjects/FreeCRMTestAutomation"
                        + "/src/main/java/com/crm/qa/config/config.properties");
                prop.load(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void initialization()
        {
            String browserName =prop.getProperty("browser");
            if(browserName.equals("chrome"))
            {
                System.setProperty("webdriver.chrome.driver","/Users/snehal/Documents/Selenium WebDrivers/Drivers/chromedriver 2");
                driver =new ChromeDriver();
            }
            else if(browserName.equals("FF")) {
                System.setProperty("webdriver.chrome.driver", "/Users/snehal/Documents/Selenium WebDrivers/Drivers/geckodriver");
                driver = new FirefoxDriver();
            }


            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITE_WAIT,TimeUnit.SECONDS);

            driver.get(prop.getProperty("url"));



        }
}
