package com.saviynt.testlogic.ars;

import com.saviynt.pages.ars.RequestApprovalPage;
import com.saviynt.pages.common.HomePage;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class ApproveRequest extends UIInteractions {
	
	HomePage homePage;
	RequestApprovalPage requestApprovalPage;
	
	@Step("Approve the request")
	public void approveRequest(String requestId) {
		homePage.clickRequestApprovalLink();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		requestApprovalPage.enterSearchTextAndEnter(requestId);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		requestApprovalPage.clickAcceptLink();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		requestApprovalPage.clickCloseButton();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
