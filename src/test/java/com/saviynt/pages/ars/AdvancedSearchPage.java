package com.saviynt.pages.ars;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;

public class AdvancedSearchPage extends PageComponent {
	
	@FindBy(id="requestid")
	private WebElementFacade requestIdInputField;
	
	@FindBy(id="dosearch")
	private WebElementFacade searchButton;

	public void enterSearchText(String requestId) {
		requestIdInputField.type(requestId);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
}
