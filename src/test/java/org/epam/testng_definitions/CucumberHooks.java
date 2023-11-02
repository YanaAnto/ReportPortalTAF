package org.epam.testng_definitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.epam.core.props.ReportPortalProperties;

@Slf4j
@RequiredArgsConstructor
public class CucumberHooks {

    private final ReportPortalProperties rpProperties;

    @Before
    public void setSelenideConfig() {
        log.info("before running test");
        Configuration.baseUrl = rpProperties.getBaseUri();
    }

    @After
    public void after() {
        log.info("After running test...");
    }
}
