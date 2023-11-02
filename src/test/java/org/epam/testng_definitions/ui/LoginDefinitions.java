package org.epam.testng_definitions.ui;

import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.epam.core.props.ReportPortalProperties;
import org.epam.core.ui.page.report_portal.LoginPage;
import org.epam.testng_definitions.BasicDefinitions;

@Slf4j
@RequiredArgsConstructor
public class LoginDefinitions extends BasicDefinitions {

    private final LoginPage loginPage;
    private final ReportPortalProperties rpProperties;

    @When("user logs in with default credentials")
    public void openReportPortalMainPage() {
        log.info("Login with user: {}", rpProperties.getUsername());
        loginPage.login(rpProperties.getUsername(), rpProperties.getPassword());
    }

    @When("user logs in with login {} and password {}")
    public void openReportPortalMainPage(String username, String password) {
        log.info("Login with user: {}", rpProperties.getUsername());
        loginPage.login(username, password);
    }

    @When("open report portal login page")
    public void openReportPortal() {
        loginPage.open();
    }

    @When("report portal login page is opened")
    public void reportPortalIsOpened() {
        loginPage.isOpened();
    }
}
