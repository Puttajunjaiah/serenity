package com.saviynt.testlogic.ars;

import com.saviynt.pages.ars.RequestAccessStep1Page;
import com.saviynt.pages.ars.RequestAccessStep2Page;
import com.saviynt.pages.ars.RequestAccessStep3Page;
import com.saviynt.pages.ars.RequestAccessStep4Page;
import com.saviynt.pages.common.HomePage;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class RequestAccess extends UIInteractions {
	HomePage homePage;
	RequestAccessStep1Page step1Page;
	RequestAccessStep2Page step2Page;
	RequestAccessStep3Page step3Page;
	RequestAccessStep4Page step4Page;
	
	@Step("Request Access For Self")
	public void requestAccessForSelf(String accountName) {
        homePage.clickRequestAccess();
        step1Page.clickAddToCart();
        step1Page.enterAccountName(accountName);
        step1Page.clickSubmitButton();
        step1Page.clickCheckoutButton();
        step2Page.clickNextButton();
        step3Page.clickFinalSubmitButton();
	}
	
	@Step("Request Access For An Endpoint")
	public String requestAccessForEndpoint(String endPointName, String accountName, String businessJustification) {
		homePage.clickRequestAccess();
        step1Page.enterSearchTextAndPressEnter(endPointName);
        step1Page.clickAddToCart();
        step1Page.enterAccountName(accountName);
        step1Page.clickSubmitButton();
        step1Page.clickCheckoutButton();
        step2Page.clickNextButton();
        //step3Page.enterBusinessJustification(businessJustification); //element not identified
        step3Page.clickFinalSubmitButton();
        return step4Page.getRequestId();
	}
	
	@Step("Get submit message")
	public String getRequestSubmitMessage() {
		return step4Page.getRequestSubmitSuccessfulMessage();
	}
}
