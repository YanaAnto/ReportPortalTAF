package org.epam.core.ui.page.report_portal;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import com.codeborne.selenide.SelenideElement;
import org.epam.core.props.ReportPortalProperties;
import org.epam.core.ui.UiBase;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class DashboardPage extends UiBase {

    private static final SelenideElement TITLE = $("span[title='All Dashboards']");

    public DashboardPage(ReportPortalProperties rpProperties) {
        super(rpProperties);
    }

    public void isOpened() {
        TITLE.shouldBe(visible);
    }

}
