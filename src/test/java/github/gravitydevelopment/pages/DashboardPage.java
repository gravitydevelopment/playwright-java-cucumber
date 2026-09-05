package github.gravitydevelopment.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DashboardPage {
    private final Page page;
    private final Locator dashboardLabelName;
    private final Locator stockListTable;

    public DashboardPage(Page page) {
        this.page = page;
        this.dashboardLabelName = page.locator("h1");
        this.stockListTable = page.locator("#stock-table");
    }

    public String getPageName(){
        return page.title();
    }

    public void verifyStockDashboardPage(){
        assertThat(dashboardLabelName).hasText("Stock Market Dashboard");
        stockListTable.isVisible();
    }
}
