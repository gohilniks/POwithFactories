package com.nbg.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
		click(home.flightTab);
		return this;
	}

	public void gotoHotels() {

	}

	public void gototFlightAndHotels() {

	}

	public void bookAFlight(String fromCity, String toCity, String departFlight, String returnFlight) {
		try {
			type(home.fromCity, fromCity);
			type(home.toCity, toCity);
			type(home.departFlight, departFlight);
			type(home.returnFlight, returnFlight);
			// home.adultCount.sendKeys("");
			click(home.flightTab);
			// Thread.sleep(3000);
			// wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(home.search));
			click(home.search);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int findTabCount() {
		return home.tabCount.size();
	}
}
