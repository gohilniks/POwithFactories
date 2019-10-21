package com.nbg.rough;

import com.nbg.base.Page;
import com.nbg.pages.actions.SigninPage;

public class SignInTest {
	public static void main(String[] args) {
		Page.initConfiguration();
		SigninPage signin = Page.topNav.gotoSignIn();
		signin.doLogin("acfsfe@gmail.com", "Test@123");
		Page.quitBrowser();
	}
}
