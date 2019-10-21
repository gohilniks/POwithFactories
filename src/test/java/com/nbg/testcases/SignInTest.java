package com.nbg.testcases;

import org.testng.annotations.Test;

import com.nbg.base.Page;
import com.nbg.pages.actions.SigninPage;

public class SignInTest {
	@Test
	public void signInTest() {
		Page.initConfiguration();
		SigninPage signin = Page.topNav.gotoSignIn();
		signin.doLogin("acfsfe@gmail.com", "Test@123");
		Page.quitBrowser();
	}
}
