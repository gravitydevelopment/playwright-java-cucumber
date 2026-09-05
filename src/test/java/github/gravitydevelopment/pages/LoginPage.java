package github.gravitydevelopment.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private final Page page;
    private final Locator usernameEntryField;
    private final Locator passwordEntryField;
    private final Locator loginButton;
    private final Locator createNewUserLink;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameEntryField = page.locator("#username");
        this.passwordEntryField = page.locator("#password");
        this.loginButton = page.locator("#loginBtn");
        this.createNewUserLink = page.locator("#createUserLink");
    }

    public void goToPage(){
        page.navigate("https://qainterview.netlify.app/");
    }

    public String getPageName(){
        return page.title();
    }

    public void verifyUsernameEntryfield(){
        assertThat(usernameEntryField).isVisible();
        assertThat(usernameEntryField).isEditable();
    }

    public void verifyPasswordEntryfield(){
        assertThat(passwordEntryField).isVisible();
        assertThat(passwordEntryField).isEditable();
    }

    public void verifyLoginButton(){
        assertThat(loginButton).hasText("Login");
        assertThat(loginButton).isDisabled();
    }

    public void verifyCreateNewUserLink(){
        assertThat(createNewUserLink).isEnabled();
        assertThat(createNewUserLink).hasText("Create new user");
    }

    public void clickCreateNewUserLink(){
        createNewUserLink.click();
        assertThat(page).hasURL("https://qainterview.netlify.app/register");
    }

    public void enterCredential(String type, String credential) {
        switch (type) {
            case "username":
                usernameEntryField.fill(credential);
                break;
            case "password":
                passwordEntryField.fill(credential);
                break;
        }
    }

    public void loginTheSystem(){
        loginButton.evaluate("element => element.removeAttribute('disabled')");
        loginButton.click();
    }
}

