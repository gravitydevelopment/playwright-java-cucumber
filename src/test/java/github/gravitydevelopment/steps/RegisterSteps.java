package github.gravitydevelopment.steps;

import github.gravitydevelopment.hooks.PlaywrightHook;
import github.gravitydevelopment.pages.RegistrationPage;
import io.cucumber.java.en.And;


public class RegisterSteps {

    private final RegistrationPage registerPage;

    public RegisterSteps(PlaywrightHook hooks) {
        this.registerPage = new RegistrationPage(hooks.getPage());
    }

    @And("User redirected to the create new user page")
    public void verifyUserRegisterPage(){
        registerPage.verifyRegisterPageName();
    }

    @And("Fill up username entry field {string}")
    public void fillUsernameEntryField(String username){
        registerPage.fillInUsernameEntryField(username);
    }

    @And("Fill up password entry field {string}")
    public void fillPasswordEntryField(String password){
        registerPage.fillInPasswordEntryField(password);
    }

    @And("Click create account button")
    public void clickRegister(){
        registerPage.clickRegisterButton();
    }

}
