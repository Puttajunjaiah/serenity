package com.saviynt.pages.common;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageComponent {

    @FindBy(id="username")
    private WebElementFacade userNameInputField;
    
    @FindBy(name="j_password")
    private WebElementFacade passwordInputField;
    
    @FindBy(xpath="//button[@type='submit']")
    private WebElementFacade submitButton;

    public void enterUsername(String username) {
        userNameInputField.type(username);
    }
    
    public void enterPassword(String password) {
    	passwordInputField.type(password);
    }
    
    public void clickSubmitButton() {
    	submitButton.click();
    }
    
}
