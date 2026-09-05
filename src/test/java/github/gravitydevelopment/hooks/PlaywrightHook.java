package github.gravitydevelopment.hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class PlaywrightHook {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;
    private Page page;
    private Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext();
        page = browserContext.newPage();
        this.scenario = scenario;
    }

    @After
    public void tearDown() {
        if (page != null) page.close();
        if (browserContext != null) browserContext.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    public Page getPage() {
        return page;
    }

    public void reportLog(String message) {
        if (this.scenario != null) {
            this.scenario.log("Test Steps:: " + message);
        }
    }
}
