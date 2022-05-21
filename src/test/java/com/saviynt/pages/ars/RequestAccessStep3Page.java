package com.saviynt.pages.ars;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;

public class RequestAccessStep3Page extends PageComponent{
	
	@FindBy(id="requestSubmit1")
    private WebElementFacade finalSubmitButton;
	
	@FindBy(id="buisnesjustifcation_128")
	private WebElementFacade businessJustifnTextArea;
	
	public void clickFinalSubmitButton() {
		finalSubmitButton.click();
	}
	
	public void enterBusinessJustification(String businessJustification) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		businessJustifnTextArea.type(businessJustification);
	}
	
}
