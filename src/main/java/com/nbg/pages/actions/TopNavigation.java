package com.nbg.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.nbg.base.Page;
import com.nbg.pages.locators.TopNavigationLocators;

public class TopNavigation {
	public TopNavigationLocators topNavigation;
	public TopNavigation(WebDriver driver) {
		this.topNavigation = new TopNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.topNavigation);
	}
	public SigninPage gotoSignIn() {
		Page.click(topNavigation.account);
		Page.click(topNavigation.signinBtn);
		return new SigninPage();
	}

	public void createAccount() {

	}

	public void gotoList() {

	}

	public void gotoSupport() {

	}

	public void gotoHome() {

	}

	public void gotoFlights() {

	}
}
