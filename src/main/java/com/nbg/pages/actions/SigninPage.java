package com.nbg.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nbg.base.Page;
import com.nbg.pages.locators.SigninPageLocators;

public class SigninPage extends Page {
	public SigninPageLocators signinPage;

	public SigninPage() {
		this.signinPage = new SigninPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.signinPage);
	}
 
	public void doLogin(String username, String password) {
		try {
			// Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(signinPage.email));
			type(signinPage.email, username);
			type(signinPage.password, password);
			click(signinPage.submit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
