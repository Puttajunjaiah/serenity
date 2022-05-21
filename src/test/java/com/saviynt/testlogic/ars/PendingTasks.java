package com.saviynt.testlogic.ars;

import org.openqa.selenium.interactions.touch.ScrollAction;

import com.saviynt.pages.ars.AdvancedSearchPage;
import com.saviynt.pages.ars.PendingTasksPage;
import com.saviynt.pages.common.HomePage;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class PendingTasks extends UIInteractions {
	
	HomePage homePage;
	PendingTasksPage pendingTasksPage;
	AdvancedSearchPage advancedSearchPage;
	
	@Step
	public void completeTask(String requestId) {
		homePage.clickTasksLink();
		homePage.clickPendingTasksLink();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pendingTasksPage.clickAdvancedSearchButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		advancedSearchPage.enterSearchText(requestId);
		advancedSearchPage.clickSearchButton();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pendingTasksPage.clickActionLink();
		pendingTasksPage.clickCompleteLink();
	}
	
}
