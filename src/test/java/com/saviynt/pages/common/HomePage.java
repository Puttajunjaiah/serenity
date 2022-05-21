package com.saviynt.pages.common;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit.*;

public class HomePage extends PageComponent {
	
    @FindBy(css=".icon-home")
    private WebElementFacade homeIcon;
    
    @FindBy(id="arsRequestAccess")
    private WebElementFacade requestAccessTile;
    
    @FindBy(xpath="//*[@id='reqapp']/a")
    private WebElementFacade requestApprovalLink;

    @FindBy(xpath="//*[@id='tsklist']/a")
    private WebElementFacade taskListLink;
    
    @FindBy(xpath="//*[@id='tsklist']/a[contains(text(),'Pending Tasks')]")
    private WebElementFacade pendingTasksLink;
   
    @FindBy(css="span.username")
    private WebElementFacade topMenuItemUserName;
    
    @FindBy(xpath="//a[contains(text(),'Log Out')]")
    private WebElementFacade linkLogOut;
    
    @FindBy(id="arsViewExistingAccess")
    private WebElementFacade viewExistingAccessTile;
    
	@FindBy(id="applicationlist_processing")
    private WebElementFacade processingAnimation;
    
    public boolean isHome() {
    	return homeIcon.isDisplayed();
    }
    
    public void clickTopMenuItemUserName() {
    	topMenuItemUserName.click();
    }
    
    public void clickRequestAccess() {
    	requestAccessTile.click();
    	waitForProcessingToFinish();
    }
    
    public void clickRequestApprovalLink() {
    	requestApprovalLink.click();
    }
    
    public void clickTasksLink() {
    	taskListLink.click();
    }
    
    public void clickPendingTasksLink() {
    	pendingTasksLink.click();
    }
    
    public void clickLogOut() {
    	linkLogOut.click();
    }
    
    public void clickViewExistingAccessTile() {
    	viewExistingAccessTile.click();
    }
    
	public void waitForProcessingToFinish() {
		setImplicitTimeout(60, ChronoUnit.SECONDS);
	    waitForCondition().until(
	            ExpectedConditions.visibilityOf(processingAnimation)
	    );
	    waitForCondition().until(
	            ExpectedConditions.invisibilityOf(processingAnimation)
	    );
	    resetImplicitTimeout();
	}    

}
