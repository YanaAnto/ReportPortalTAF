package org.epam.core.ui.page.report_portal;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.epam.core.props.ReportPortalProperties;
import org.epam.core.ui.UiBase;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class LoginPage extends UiBase {

    private static final SelenideElement LOGIN_INPUT = $("input[name='login']");
    private static final SelenideElement PASSWORD_INPUT = $("input[name='password']");
    private static final SelenideElement LOGIN_BUTTON = $("button[type='submit']");

    public LoginPage(ReportPortalProperties rpProperties) {
        super(rpProperties);
    }

    public void open() {
        Configuration.baseUrl = rpProperties.getBaseUri();
        Selenide.open("/ui/#login");
    }

    public void login(String username, String password) {
        LOGIN_INPUT.shouldBe(visible).clear();
        LOGIN_INPUT.sendKeys(username);
        PASSWORD_INPUT.shouldBe(visible).clear();
        PASSWORD_INPUT.sendKeys(password);
        LOGIN_BUTTON.click();
    }
}
