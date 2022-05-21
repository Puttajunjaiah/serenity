package com.saviynt.testlogic.ars;

import com.saviynt.pages.ars.ViewExistingAccessPage;
import com.saviynt.pages.common.HomePage;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class ViewExistingAccess extends UIInteractions {
	
	HomePage homePage;
	ViewExistingAccessPage viewExistingAccessPage;
	
	@Step
	public String getApplicationAccounts(String applicationName) {
		homePage.clickViewExistingAccessTile();
		viewExistingAccessPage.clickApplicationLink();
		try {
			wait(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewExistingAccessPage.clickApplicationDropDownLink();
		viewExistingAccessPage.enterSearchTextAndEnter(applicationName);
		try {
			wait(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return viewExistingAccessPage.getAccountsTableData();
	}
}
