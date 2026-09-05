package github.gravitydevelopment.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private final Page page;
    private final Locator usernameEntryfield;
    private final Locator passwordEntryField;
    private final Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameEntryfield = page.locator("#username");
        this.passwordEntryField = page.locator("#password");
        this.loginButton = page.locator("#loginBtn");
    }

    public void goToPage(){
        page.navigate("https://qainterview.netlify.app/");
    }

    public String getPageName(){
        return page.title();
    }

    public void verifyUsernameEntryfield(){
        assertThat(loginButton).isVisible();
        assertThat(loginButton).isEditable();
    }

    public void verifyPasswordEntryfield(){
        assertThat(loginButton).isVisible();
        assertThat(loginButton).isEditable();
    }

    public void verifyLoginButton(){
        assertThat(loginButton).isEnabled();
        assertThat(loginButton).hasText("Login");
    }



}