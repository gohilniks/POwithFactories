package com.nbg.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.nbg.base.Page;
import com.nbg.pages.actions.HomePage;
import com.nbg.utilities.Utilities;

public class FlightSearchTest {
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void flightSearchTest(Hashtable<String, String> data) throws Exception {
		if (data.get("runmode").equalsIgnoreCase("N")) {
			throw new SkipException("Skipping the test as the Run Mode is NO");
		}
		Page.initConfiguration();
		HomePage home = new HomePage();
		Page.verifyEquals(home.findTabCount(), 6);
		home.gotoFlight().bookAFlight(data.get("fromCity"), data.get("toCity"), data.get("fromDate"),
				data.get("toDate"));
	}

	@AfterMethod
	public void tearDown() {
		if (Page.driver != null) {
			Page.quitBrowser();
		}
	}
}
