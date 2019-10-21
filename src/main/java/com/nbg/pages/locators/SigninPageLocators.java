package com.nbg.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPageLocators {
	@FindBy(css = "#gss-signin-email")
	public WebElement email;
	
	@FindBy(css = "#gss-signin-password")
	public WebElement password;
	
	@FindBy(css = "#gss-signin-submit")
	public WebElement submit;
}
