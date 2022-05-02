package com.saviynt.pages.common;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends PageComponent {
	
    @FindBy(css=".icon-home")
    private WebElementFacade homeIcon;
    
    @FindBy(id="arsRequestAccess")
    private WebElementFacade requestAccessTile;
    
    public boolean isHome() {
    	return homeIcon.isDisplayed();
    }
    
    public void clickRequestAccess() {
    	requestAccessTile.click();
    }

}
