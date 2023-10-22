package org.epam.definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.epam.core.props.ReportPortalProperties;
import org.epam.core.ui.page.report_portal.LoginPage;

@Slf4j
@RequiredArgsConstructor
public class BasicDefinitions {

    private final LoginPage loginPage;
    private final ReportPortalProperties rpProperties;

    @When("login with default user")
    public void openReportPortalMainPage() {
        log.info("Login with user: {}", rpProperties.getUsername());
        loginPage.login(rpProperties.getUsername(), rpProperties.getPassword());
    }

    @When("open report portal main page")
    public void openReportPortal() {
        loginPage.open();
    }

    @Then("title is visible")
    public void verifyTitleIsVisible() {
        // todo: add check that title is visible
    }
}
