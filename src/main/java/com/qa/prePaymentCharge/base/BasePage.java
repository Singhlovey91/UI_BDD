package com.qa.prePaymentCharge.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.prePaymentCharge.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	
	
		public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>(); 	
		
		public static synchronized WebDriver getDriver() {
			return tlDriver.get();						  
		}												  
		

		WebDriver driver;
		
		Properties prop;
		
		public OptionsManager optionsManager; //1

	
		public WebDriver init_driver(Properties prop) {
			optionsManager = new OptionsManager(prop); 
			String browserName = prop.getProperty("browsername"); 
			
			if (browserName.equalsIgnoreCase("chrome")) { 
				WebDriverManager.chromedriver().setup();
				
				tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
				}
			
			else if(browserName.equalsIgnoreCase("firefox")) { 
				WebDriverManager.firefoxdriver().setup();
				
				tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			}
			
			else if(browserName.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup(); 
				
				tlDriver.set(new InternetExplorerDriver());
			}
			
			
			
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			
		
			
			getDriver().get(prop.getProperty("url"));
			
			
			
			return getDriver();
		}
		
		/**
		 * This method is used for initialize properties from config.properties
		 * @return
		 */
		
		public Properties init_prop() {
			
			prop = new Properties();
			
			String path = null;
			String env = null;
			
			try {
				env = System.getProperty("env");
				
				if (env == null) {
					path = "./config.properties";
				}else if(env.equals("qa")) {
					path = "./config.properties";
				}else if(env.equals("uat")) {
					path = "./config.properties";
				}else {
					System.out.println("Please pass the correct path");
				}
				
				
				FileInputStream ip = new FileInputStream(path);
				
				
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return prop;
		}
		
		
		public String getScreenshot() {
			File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
			File destination = new File(path);
			try {
				FileUtils.copyFile(src, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return path;
		}
		
		

}
