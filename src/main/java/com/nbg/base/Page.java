package com.nbg.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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
	
	
	public static void initConfiguration() {
		
	}
	
	public static void quitBrowser() {
		
	}
	
}

