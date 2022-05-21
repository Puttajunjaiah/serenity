package com.saviynt.testlogic.common;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

/**
 * UIInteractionSteps let us define action classes which regroup related actions.
 * The @Step annotation is used to indicate that this action will appear as a step in the reports.
 */
public class NavigateActions extends UIInteractions {
    @Step("Navigate to the login page")
    public void toTheHomePage() {
        openUrl("https://assuredcompliance-v5sp9.saviyntcloud.com/ECM/login/auth");
    }
}
