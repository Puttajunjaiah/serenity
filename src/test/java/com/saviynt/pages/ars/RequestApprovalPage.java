package com.saviynt.pages.ars;

import org.openqa.selenium.interactions.touch.ScrollAction;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;

public class RequestApprovalPage extends PageComponent {
	
	@FindBy(id="dtsearch_myDataTable123")
	private WebElementFacade searchInputField;
	
	@FindBy(xpath="//a[@aria-label='Accept']")
	private WebElementFacade acceptLink;
	
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElementFacade closeButton;
	
	public void enterSearchTextAndEnter(String searchText) {
		searchInputField.typeAndEnter(searchText);
	}
	
	public void clickAcceptLink() {
		acceptLink.click();
	}
	
	public void clickCloseButton() {
		closeButton.click();
	}

}
