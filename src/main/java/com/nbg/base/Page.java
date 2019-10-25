package com.nbg.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.nbg.pages.actions.TopNavigation;
import com.nbg.utilities.ExcelReader;
import com.nbg.utilities.ExtentManager;
import com.nbg.utilities.Utilities;

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

	public static void click(WebElement element) {
		element.click();
		log.debug("Clicking on an Element : " + element);
		test.log(Status.INFO, "Clicking on : " + element);
	}
	
	public static void type(WebElement element, String value) {
		element.sendKeys(value);
		log.debug("Type in an Element : " + element + " entered value as : " + value);
		test.log(Status.INFO, "Type in : " + element + " entered value as " + value);
	}
	

	public static void verifyEquals(String actual, String expected) throws Exception {
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable t) {
			// TestUtil.captureScreenshot();
			/* ReportNG */
			Reporter.log("</br>" + "Verification failure : " + t.getMessage() + "</br>");
			// Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img
			// height=200 width=200 src="
			// + TestUtil.screenshotName + "></img> </a>");
			// Reporter.log("</br>");
			// Reporter.log("</br>");

			test.log(Status.FAIL, " Verification Failed with exception : " + t.getMessage());
			// test.log(Status.FAIL, "Test Fail",
			// MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName).build());
		}
	}

	public static void verifyEquals(int actual, int expected) throws Exception {
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable t) {
			Utilities.captureScreenshot();
			/* ReportNG */
			Reporter.log("</br>" + "Verification failure : " + t.getMessage() + "</br>");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img height=200 width=200 src="
			+ Utilities.screenshotName + "></img> </a>");
			Reporter.log("</br>");
			Reporter.log("</br>");

			test.log(Status.FAIL, " Verification Failed with exception : " + t.getMessage());
			test.log(Status.INFO, "Test Fail",
			MediaEntityBuilder.createScreenCaptureFromPath(Utilities.screenshotName).build());
		}
	}

	public static void quitBrowser() {
		driver.quit();
	}

}
