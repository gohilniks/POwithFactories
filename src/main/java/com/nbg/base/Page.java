package com.nbg.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.nbg.pages.actions.TopNavigation;
import com.nbg.utilities.ExcelReader;
import com.nbg.utilities.ExtentManager;

public class Page {
	public static WebDriver driver;
	public static String path = System.getProperty("user.dir");
	public static Logger log = LogManager.getLogger();
	public static ExcelReader excel = new ExcelReader(path + "\\src\\test\\resources\\com\\nbg\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public static ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static TopNavigation topNav;

	public static void initConfiguration() {
		switch (Constants.browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", path + "\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.debug("Firefox launched");
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", path + "\\chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

			driver = new ChromeDriver(options);
			log.debug("Chrome launched");
			break;
		default:
			break;
		}

		driver.manage().window().maximize();
		/*
		 * driver.manage().timeouts().implicitlyWait(Constants.implicitwait,
		 * TimeUnit.SECONDS);
		 * driver.manage().timeouts().pageLoadTimeout(Constants.pageloadwait,
		 * TimeUnit.SECONDS);
		 */
		driver.get(Constants.testsiteurl);
		log.debug("Navigated to " + Constants.testsiteurl);
		topNav = new TopNavigation(driver);
		wait = new WebDriverWait(driver, 15);
	}

	public static void quitBrowser() {
		driver.quit();
	}

}
