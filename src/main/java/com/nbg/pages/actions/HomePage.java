package com.nbg.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nbg.base.Page;
import com.nbg.pages.locators.HomePageLocators;

public class HomePage extends Page {
	
	public HomePageLocators home;
	public HomePage() {
		this.home = new HomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.home);
	}
	
	public HomePage gotoFlight() {
		home.flightTab.click();
		return this;
	}
	
	public void gotoHotels() {
		
	}
	
	public void gototFlightAndHotels() {
		
	}
	
	public void bookAFlight(String fromCity, String toCity, String departFlight, String returnFlight) {
		try {
			home.fromCity.sendKeys(fromCity);
			home.toCity.sendKeys(toCity);
			home.departFlight.sendKeys(departFlight);
			home.returnFlight.sendKeys(returnFlight);
			//home.adultCount.sendKeys("");
			home.flightTab.click();
			//Thread.sleep(3000);
			//wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(home.search));
			home.search.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
