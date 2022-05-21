package com.saviynt.testlogic.common;

import com.saviynt.pages.common.HomePage;
import com.saviynt.pages.common.LoginPage;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class Login extends UIInteractions{
	
	LoginPage loginPage;
	HomePage homePage;

	@Step("Login with username and password")
    public void login(String username, String password) throws InterruptedException {
		loginPage.openAt("/login/auth");
    	loginPage.enterUsername(username);
    	loginPage.enterPassword(password);
    	loginPage.clickSubmitButton();
    }
	
	@Step("Logout")
	public void logout() {
		homePage.clickTopMenuItemUserName();
		homePage.clickLogOut();
	}
	
}
