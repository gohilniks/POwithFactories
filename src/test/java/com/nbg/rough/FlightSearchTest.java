package com.nbg.rough;

import com.nbg.base.Page;
import com.nbg.pages.actions.HomePage;

public class FlightSearchTest {
	
	
	public static void main(String[] args) {
		Page.initConfiguration();
		HomePage home = new HomePage();
		home.gotoFlight().bookAFlight("Delhi, India (DEL-Indira Gandhi Intl.)", "Mumbai, India (BOM-Chhatrapati Shivaji Intl.)", "21/10/2019", "23/10/2019");
		Page.quitBrowser();
	}
}
