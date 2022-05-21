package com.saviynt.pages.ars;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;

public class RequestAccessStep2Page extends PageComponent {
	
	@FindBy(id="nxtButton")
    private WebElementFacade nextButton;
	
	public void clickNextButton() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nextButton.click();
	}
	
}
