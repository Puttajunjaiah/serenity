package com.saviynt.pages.ars;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;

public class RequestAccessStep1Page extends PageComponent {
	
	@FindBy(xpath="//*[@id='applicationlist']//a[@aria-label='Add to Cart']")
    private WebElementFacade addToCart;
	
	@FindBy(id="accountnamealert")
    private WebElementFacade accountNameInputField;
	
	@FindBy(id="addtocartsubmit")
    private WebElementFacade submitButton;
	
	@FindBy(id="arsReqAcessCheckout")
    private WebElementFacade checkoutButton;
	
	@FindBy(id="applicationlist_processing")
    private WebElementFacade processingAnimation;
	
	@FindBy(id="dtsearch_applicationlist")
	private WebElementFacade searchInputField;
	
	public void clickAddToCart() {
		addToCart.click();
	}
	
	public void enterAccountName(String accountName) {
		accountNameInputField.type(accountName);
	}
	
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	public void clickCheckoutButton() {
		checkoutButton.click();
	}
	
	public void enterSearchTextAndPressEnter(String searchText) {
		searchInputField.typeAndEnter(searchText);
	}
	
}
