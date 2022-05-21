package com.saviynt.tests.ars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import com.saviynt.testlogic.ars.ApproveRequest;
import com.saviynt.testlogic.ars.PendingTasks;
import com.saviynt.testlogic.ars.RequestAccess;
import com.saviynt.testlogic.ars.ViewExistingAccess;
import com.saviynt.testlogic.common.Login;
import com.saviynt.testlogic.common.NavigateActions;
import com.saviynt.utils.CommonUtils;

import io.restassured.RestAssured;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;

@ExtendWith(SerenityJUnit5Extension.class)
class AccessRequestForSelfWorkflowTest {

	private String requestId = null;
	
	/**
     * Login,RequestAccess. These are UIInteraction classes so they will be instantiated automatically by Serenity.
     */
    Login login;
    RequestAccess requestAccess;
    ApproveRequest approveRequest;
    PendingTasks pendingTasks;
    ViewExistingAccess viewExistingAccess;
    
    @Test
    void userRequestsAccessForAnAccountAndTheAccountIsSuccessfullyProvisioned() throws InterruptedException {
    	String accountName = "Account_"+ CommonUtils.generateUUID();
    	String securitySystemName = "Auto_Security_C12063621";
    	
    	//Login as end user and request account creation for endpoint
        login.login("Auto_enduser_Uz", "Uzer@1234");
        requestId = requestAccess.requestAccessForEndpoint("Auto_Endpoint_C12063621", accountName, "Business Justification");
        login.logout();
        
        //Login as manager and approve the request
        login.login("Auto_seniorMgr_Uz", "Uzer@1234");
        approveRequest.approveRequest(requestId);
        login.logout();
        
        //Login as admin and complete the task
        login.login("Auto_admin_Uz", "Uzer@1234");
        pendingTasks.completeTask(requestId);
        login.logout();
        
        //Log back as end user and verify account has been created successfully
        login.login("Auto_enduser_Uz", "Uzer@1234");

        Serenity.reportThat("Account is successfully created",
                () -> assertThat(viewExistingAccess.getApplicationAccounts(securitySystemName)).containsOnlyOnce(accountName));
        
        login.logout();
    }
    
    @Test
    void userShouldBeAbleToRequestAccessForSelf() throws InterruptedException {
        login.login("Auto_User_001", "S@viynt001");
        requestAccess.requestAccessForSelf("MyTestAccount1");

        Serenity.reportThat("Request is successfully submitted",
                () -> assertThat(requestAccess.getRequestSubmitMessage()).isEqualTo("Your request has been submitted")
        );

    }
    
	@Test
	public void verifyThatStarshipHasADeathStar(){
		RestAssured.
           	when().
           		get("https://swapi.dev/api/starships/9").
           	then().
           		assertThat().statusCode(200).
           	and().
           		body("name", is("Death Star"));
	}

}
