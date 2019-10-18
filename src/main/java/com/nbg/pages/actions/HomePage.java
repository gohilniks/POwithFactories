package com.nbg.pages.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(css = "#tab-flight-tab-hp")
	public WebElement flightTab;
	
	public void gotoFlight() {
		flightTab.click();
	}
	
	public void gotoHotels() {
		
	}
	
	public void gototFlightAndHotels() {
		
	}
	
	public void bookAFlight() {
		
	}
}
