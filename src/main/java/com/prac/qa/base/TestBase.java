package com.prac.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.prac.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	static Properties prop;

	// test base class constructor
	public TestBase() {
		prop = new Properties();

		try {
			FileInputStream io = new FileInputStream("G:\\Automation_Workspace\\TestPracticeProject\\src\\main"
					+ "\\java\\com\\prac\\qa\\config\\config.properties");
			prop.load(io);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//
	public static void Initialization()

	{
		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "G:\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browsername.equals("IE")) {
			System.setProperty("webdriver.gecko.driver", "G:\\Selenium\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		  driver.manage().window().maximize();
		  
		  driver.manage().deleteAllCookies();
		  
		  driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
		  
		  driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait_time, TimeUnit.SECONDS);
		  
		  driver.get(prop.getProperty("url"));
		 
	}
}
