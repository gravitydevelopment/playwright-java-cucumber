package github.gravitydevelopment.steps;

import github.gravitydevelopment.hooks.PlaywrightHook;
import github.gravitydevelopment.pages.LoginPage;
import io.cucumber.java.en.*;

public class LoginSteps {
    private final PlaywrightHook hooks;
    private LoginPage mp;

    public LoginSteps(PlaywrightHook hooks) {
        this.hooks = hooks;
    }

}
