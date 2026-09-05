package github.gravitydevelopment.steps;

import com.microsoft.playwright.Page;
import github.gravitydevelopment.hooks.PlaywrightHook;
import github.gravitydevelopment.pages.DashboardPage;
import io.cucumber.java.en.When;

public class DashboardSteps {
    private final DashboardPage dashboardPage;
    private final Page page;

    public DashboardSteps(PlaywrightHook hooks) {
        this.page = hooks.getPage();
        this.dashboardPage = new DashboardPage(this.page);
    }

    @When("User verify the system redirect user to the Stock Market Dashboard")
    public void verifyPageName() throws InterruptedException {
        String expected = "Stock Market Dashboard";

        page.waitForURL("**/dashboard.html");
        assert expected.equals(dashboardPage.getPageName()) : "Page name mismatch! Expected: '" + expected + "' actual: '" + dashboardPage.getPageName() + "'";
        dashboardPage.verifyStockDashboardPage();
    }
}
