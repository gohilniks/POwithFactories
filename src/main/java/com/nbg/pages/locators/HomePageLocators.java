package com.nbg.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
	@FindBy(css = "#tab-flight-tab-hp")
	public WebElement flightTab;
	
	//locators for flight booking
	@FindBy(css = "#flight-origin-hp-flight")
	public WebElement fromCity;
	
	@FindBy(css = "#flight-destination-hp-flight")
	public WebElement toCity;
	
	@FindBy(css = "#flight-departing-hp-flight")
	public WebElement departFlight;
	
	@FindBy(css = "#flight-returning-hp-flight")
	public WebElement returnFlight;
	
	@FindBy(css = "div#traveler-selector-hp-flight > div > ul > li > button")
	public WebElement adultCount;
	
	@FindBy(xpath = "//form[@id='gcw-flights-form-hp-flight']//button[@class='btn-primary btn-action gcw-submit']")
	public WebElement search;
	
	@FindBy(css="#hero-banner")
	public WebElement block;
	
	@FindBy(css = "ul.tabs.cf.col > li")
	public List<WebElement> tabCount;
}
