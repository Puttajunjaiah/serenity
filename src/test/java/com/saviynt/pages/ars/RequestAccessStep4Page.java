package com.saviynt.pages.ars;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;

public class RequestAccessStep4Page extends PageComponent {
	
	@FindBy(css="div.note-success p")
    private WebElementFacade requestSubmitMessage;
	
	@FindBy(xpath="//*[@id='middlepart']//tbody/tr/td[2]")
	private WebElementFacade requestId;
	
	public String getRequestSubmitSuccessfulMessage() {
		return requestSubmitMessage.getText();
	}
	
	public String getRequestId() {
		return requestId.getTextValue();
	}
	
	public String getRequestId(String username) {
		String xpathExpression = "//td[text()='"+ username +"']/../td[2]";
		return find(By.xpath(xpathExpression)).getTextValue();
	}
}
