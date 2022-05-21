package com.saviynt.pages.ars;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;

public class ViewExistingAccessPage extends PageComponent {
	
	@FindBy(xpath="//a[contains(text(),'Application')]")
	private WebElementFacade applicationLink;
	
	@FindBy(id="s2id_autogen6")
	private WebElementFacade applicationDropDownLink;
	
	@FindBy(xpath="//input[@aria-label='Search']")
	private WebElementFacade searchInputField;
	
	@FindBy(id="accordion1")
	private WebElementFacade accountsTable;
	
	
	public void clickApplicationLink() {
		applicationLink.click();
	}
	
	public void clickApplicationDropDownLink() {
		applicationDropDownLink.click();
	}
	
	public void enterSearchTextAndEnter(String searchText) {
		searchInputField.typeAndEnter(searchText);
	}
	
	public String getAccountsTableData() {
		return accountsTable.getTextContent();
	}
}
