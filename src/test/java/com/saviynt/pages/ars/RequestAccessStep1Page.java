package com.saviynt.pages.ars;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;

public class RequestAccessStep1Page extends PageComponent{
	
	@FindBy(xpath="//*[@id='applicationlist']//a[@aria-label='Add to Cart']")
    private WebElementFacade addToCart;
	
	@FindBy(id="accountnamealert")
    private WebElementFacade accountNameInputField;
	
	@FindBy(id="addtocartsubmit")
    private WebElementFacade submitButton;
	
	@FindBy(id="arsReqAcessCheckout")
    private WebElementFacade checkoutButton;
	
	@FindBy(id="nxtButton")
    private WebElementFacade nextButton;
	
	@FindBy(id="requestSubmit1")
    private WebElementFacade finalSubmitButton;
	
	@FindBy(css="div.note-success p")
    private WebElementFacade requestSubmitMessage;
	
	@FindBy(id="applicationlist_processing")
    private WebElementFacade processingAnimation;
	
	
	
	public void clickAddToCart() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void clickNextButton() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nextButton.click();
	}
	
	public void clickFinalSubmitButton() {
		finalSubmitButton.click();
	}
	
	public String getRequestSubmitSuccessfulMessage() {
		return requestSubmitMessage.getText();
	}
}
