package com.nbg.rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.nbg.pages.actions.HomePage;

public class FlightSearchTest {
	
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.expedia.co.in/");
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.gotoFlight();
	}
}
