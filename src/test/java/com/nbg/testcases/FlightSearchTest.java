package com.nbg.testcases;

import org.testng.annotations.Test;

import com.nbg.base.Page;
import com.nbg.pages.actions.HomePage;

public class FlightSearchTest {
	
	@Test
	public void flightSearchTest() {
		Page.initConfiguration();
		HomePage home = new HomePage();
		home.gotoFlight().bookAFlight("Delhi, India (DEL-Indira Gandhi Intl.)", "Mumbai, India (BOM-Chhatrapati Shivaji Intl.)", "21/10/2019", "23/10/2019");
		Page.quitBrowser();
	}
}
