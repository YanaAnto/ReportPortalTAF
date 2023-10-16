package org.epam.core.ui;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.refresh;
import static org.awaitility.Awaitility.await;
import static org.epam.core.utils.WaitUtils.THIRTY_SECONDS;
import static org.epam.core.utils.WaitUtils.kindlyWait;

import com.codeborne.selenide.SelenideElement;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.awaitility.core.ConditionFactory;
import org.epam.core.props.ReportPortalProperties;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UiBase {

    protected final ReportPortalProperties rpProperties;

    protected ConditionFactory wait = await()
        .atMost(THIRTY_SECONDS, TimeUnit.SECONDS)
        .pollInSameThread();

    protected SelenideElement waitUntilDisplayed(final SelenideElement element) {
        wait.until(element::isDisplayed);
        return element;
    }

    protected void refreshPage() {
        refresh();
        kindlyWait(THIRTY_SECONDS)
            .until(() -> "complete".equals(executeJavaScript("return document.readyState")));
    }
}
