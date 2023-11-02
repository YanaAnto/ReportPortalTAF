package org.epam.testng_definitions.ui;

import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.epam.core.ui.page.report_portal.DashboardPage;
import org.epam.testng_definitions.BasicDefinitions;

@RequiredArgsConstructor
public class DashboardDefinitions extends BasicDefinitions {

    private final DashboardPage dashboardPage;

    @Then("dashboard page is opened")
    public void dashboardPageIsOpened() {
        dashboardPage.isOpened();
    }
}
