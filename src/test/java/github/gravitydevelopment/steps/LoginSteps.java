package github.gravitydevelopment.steps;

import github.gravitydevelopment.hooks.PlaywrightHook;
import github.gravitydevelopment.pages.LoginPage;
import io.cucumber.java.en.*;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(PlaywrightHook hooks) {
        this.loginPage = new LoginPage(hooks.getPage());
    }

    @Given("Access Qainterview login page")
    public void accessLoginPage(){ loginPage.goToPage();}

    @When("Verify page name is correct")
    public void verifyPageName(){
        assert loginPage.getPageName().equals("Login Page");
    }

    @Then("Verify Username and Password entry fields existed")
    public void verifyCredentialEntryFields(){
        loginPage.verifyUsernameEntryfield();
        loginPage.verifyPasswordEntryfield();
    }

    @And("Verify login button is visible with default disable")
    public void verifyLoginPage(){
        loginPage.verifyLoginButton();
    }

    @And("Verify link for creating new user existed")
    public void verifyCreateNewUserLink(){
        loginPage.verifyCreateNewUserLink();
    }

    @And("Click register new user link")
    public void clickRegisterLink(){
        loginPage.clickCreateNewUserLink();
    }

    @And("User enter username {string}")
    public void enterUsername(String username) {
        loginPage.enterCredential("username", username);
    }

    @And("User enter password {string}")
    public void enterPassword(String password) {
        loginPage.enterCredential("password", password);
    }

    @And("User click login button and access the system")
    public void accessingTheSystem() {
        loginPage.loginTheSystem();
    }




}
