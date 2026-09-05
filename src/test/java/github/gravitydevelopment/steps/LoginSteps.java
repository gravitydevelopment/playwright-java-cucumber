package github.gravitydevelopment.steps;

import github.gravitydevelopment.hooks.PlaywrightHook;
import github.gravitydevelopment.pages.LoginPage;
import io.cucumber.java.en.*;

public class LoginSteps {
    private final PlaywrightHook hooks;
    private LoginPage loginPage;

    public LoginSteps(PlaywrightHook hooks) {
        this.hooks = hooks;
    }

    @Given("Access Qainterview login page")
    public void accessLoginPage(){
        loginPage = new LoginPage(hooks.getPage());
        loginPage.goToPage();
        hooks.reportLog("Verified successfully accessing Qainterview Webpage");
    }

    @When("Verify page name is correct")
    public void verifyPageName(){
        assert loginPage.getPageName().equals("Login Page");
        hooks.reportLog("Actual page name: " + loginPage.getPageName());
    }

    @Then("Verify Username and Password entry fields existed")
    public void verifyCredentialEntryFields(){
        loginPage.verifyUsernameEntryfield();
        hooks.reportLog("Username Entry field existed");
        loginPage.verifyPasswordEntryfield();
        hooks.reportLog("Password Entry field existed");
    }

    @And("Verify login button is displayed")
    public void verifyLoginPage(){
        loginPage.verifyLoginButton();
    }
}
