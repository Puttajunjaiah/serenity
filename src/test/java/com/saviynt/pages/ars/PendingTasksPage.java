package com.saviynt.pages.ars;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;

public class PendingTasksPage extends PageComponent {
	
	@FindBy(id="dtsearch_usersList")
	private WebElementFacade searchInputField;
	
	@FindBy(id="advSearchButton_usersList")
	private WebElementFacade advancedButton;
	
	@FindBy(xpath="//a[contains(text(),'Action']")
	private WebElementFacade actionLink;
	
	@FindBy(xpath="//a[contains(text(),'Complete']")
	private WebElementFacade completeLink;
	
	public void enterSearchText(String searchText) {
		searchInputField.typeAndEnter(searchText);
	}
	
	public void clickAdvancedSearchButton() {
		advancedButton.click();
	}
	
	public void clickActionLink() {
		actionLink.click();
	}
	
	public void clickCompleteLink() {
		completeLink.click();
	}
}
