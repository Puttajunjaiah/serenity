package com.saviynt.tests.ars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import com.saviynt.pages.ars.RequestAccessStep1Page;
import com.saviynt.pages.common.HomePage;
import com.saviynt.pages.common.LoginPage;

import io.restassured.RestAssured;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;

@ExtendWith(SerenityJUnit5Extension.class)
class LoginTest {

    /**
     * Define the webdriver instance to be used for these tests
     */
    @Managed(driver = "chrome", options = "")
    WebDriver driver;

    /**
     * Navigation actions. This is a UIInteraction class so it will be instantiated automatically by Serenity.
     */
    NavigateActions navigate;

   
    LoginPage loginPage;
    HomePage homePage;
    RequestAccessStep1Page step1Page;


    @Test
    void shouldSuccessfullyLoginUsingValidCredentials() {
        navigate.toTheHomePage();
        loginPage.login("admin", "SaviyntP@ssw0rd");

        Serenity.reportThat("Should successfully land on home page",
                () -> assertThat(homePage.isHome()).isTrue()
        );
    }
    
    @Test
    void userShouldBeAbleToRequestAccessForSelf() {
        navigate.toTheHomePage();
        loginPage.login("Auto_User_001", "S@viynt001");
        homePage.clickRequestAccess();
        step1Page.clickAddToCart();
        step1Page.enterAccountName("MyTestAccount1");
        step1Page.clickSubmitButton();
        step1Page.clickCheckoutButton();
        step1Page.clickNextButton();
        step1Page.clickFinalSubmitButton();
        
        Serenity.reportThat("Request is submitted",
                () -> assertThat(step1Page.getRequestSubmitSuccessfulMessage()).isEqualTo("Your request has been submitted")
        );

    }
    
	@Test
	public void verifyThatWeCanFindUnitedStatesOfAmericaUsingTheCodeUS(){
		RestAssured.
           	when().
           		get("https://swapi.dev/api/starships/9").
           	then().
           		assertThat().statusCode(200).
           	and().
           		body("name", is("Death Star"));
	}

}
