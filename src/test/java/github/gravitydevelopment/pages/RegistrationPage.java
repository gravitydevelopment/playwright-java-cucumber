package github.gravitydevelopment.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegistrationPage {

    private final Page page;
    private final Locator usernameEntryField;
    private final Locator passwordEntryField;
    private final Locator registerButton;

    public RegistrationPage(Page page) {
        this.page = page;
        this.usernameEntryField = page.locator("#newUsername");
        this.passwordEntryField = page.locator("#newPassword");
        this.registerButton = page.locator("#registerBtn");
    }

    public void verifyRegisterPageName(){
        assert page.title().equals("Create New User");
    }

    public void fillInUsernameEntryField(String username){
        usernameEntryField.fill(username);
    }

    public void fillInPasswordEntryField(String password){
        passwordEntryField.fill(password);
    }

    public void clickRegisterButton(){
        registerButton.evaluate("element => element.removeAttribute('disabled')");
        registerButton.click();
    }


}
