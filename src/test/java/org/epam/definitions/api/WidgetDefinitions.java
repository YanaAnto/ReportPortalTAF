package org.epam.definitions.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.epam.core.utils.FileUtil.readFromFileNamed;
import static org.epam.core.utils.ScenarioContext.Context.CREATE_WIDGET_REQUEST;
import static org.epam.core.utils.ScenarioContext.Context.CREATE_WIDGET_RESPONSE;
import static org.epam.core.utils.ScenarioContext.Context.UPDATE_WIDGET_RESPONSE;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.epam.core.api.ReportPortalApiService;
import org.epam.core.props.ReportPortalProperties;
import org.epam.core.utils.ScenarioContext;
import org.epam.definitions.BasicDefinitions;
import org.json.JSONObject;

@Slf4j
@RequiredArgsConstructor
public class WidgetDefinitions extends BasicDefinitions {

    private final ReportPortalProperties rpProperties;
    private final ReportPortalApiService rpApiService;
    private final ScenarioContext scenarioContext;

    @SneakyThrows
    @And("create widget from file {}")
    public void createWidget(String filePath) {
        String jsonData = readFromFileNamed("test_data", "widget/request/%s".formatted(filePath))
            .replace("widgetName", "Default_".concat(RandomStringUtils.randomAlphanumeric(5)));
        scenarioContext.set(CREATE_WIDGET_REQUEST, jsonData);
        Response createWidgetResponse = rpApiService
            .createWidget(jsonData, rpProperties.getProjectName());
        log.info("Create widget response: {}", createWidgetResponse.getBody().prettyPrint());
        assertThat(createWidgetResponse.getStatusCode())
            .as("Incorrect status code!")
            .isEqualTo(201);
        scenarioContext.set(CREATE_WIDGET_RESPONSE, createWidgetResponse);
    }

    @Then("widget is created")
    public void widgetIsCreated() {
        Response createWidgetResponse = scenarioContext.get(CREATE_WIDGET_RESPONSE);
        String widgetId = createWidgetResponse.getBody().jsonPath().getString("id");
        Response getWidgetResponse = rpApiService
            .getWidgetById(rpProperties.getProjectName(), widgetId);
        log.info("Get widget response: {}", getWidgetResponse.getBody().prettyPrint());
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(getWidgetResponse.getStatusCode())
                .as("Incorrect status code!")
                .isEqualTo(200);
            softAssertions.assertThat(getWidgetResponse)
                .isNotNull();
        });
    }

    @SneakyThrows
    @When("update widget with field {} and value {}")
    public void updateWidgetFieldFieldWithValueValue(String field, String value) {
        Thread.sleep(1000);
        String jsonData = scenarioContext.get(CREATE_WIDGET_REQUEST);
        JSONObject json = new JSONObject(jsonData);
        json.put(field, value);
        String updatedJsonData = json.toString();
        Response createWidgetResponse = scenarioContext.get(CREATE_WIDGET_RESPONSE);
        String widgetId = createWidgetResponse.getBody().jsonPath().getString("id");
        Response updateWidgetResponse = rpApiService
            .updateWidgetById(updatedJsonData, rpProperties.getProjectName(), widgetId);
        log.info("Update widget response: {}", updateWidgetResponse.getBody().prettyPrint());
        scenarioContext.set(UPDATE_WIDGET_RESPONSE, updateWidgetResponse);
    }

    @When("widget is updated")
    public void updateWidgetFieldFieldWithValueValue() {
        Response updateWidgetResponse = scenarioContext.get(UPDATE_WIDGET_RESPONSE);
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(updateWidgetResponse.getStatusCode())
                .as("Incorrect status code!")
                .isEqualTo(200);
            softAssertions.assertThat(updateWidgetResponse)
                .isNotNull();
        });
    }

}
