package github.gravitydevelopment.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {


    private final Page page;
    private final Locator TopMainMenuDropDownButton;

    public LoginPage(Page page) {
        this.page = page;
        this.TopMainMenuDropDownButton = page.locator("");
    }

    public void goToPage(){
        page.navigate("https://qainterview.netlify.app/");
    }

    public String getPageName(){
        return page.title();
    }

    public void verifyMainMenuButton(){
        assertThat(TopMainMenuDropDownButton).hasText("Login");
    }



}