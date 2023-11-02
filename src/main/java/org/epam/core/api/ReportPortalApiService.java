package org.epam.core.api;

import static org.epam.core.api.ReportPortalApiService.Endpoint.CREATE_WIDGET;
import static org.epam.core.api.ReportPortalApiService.Endpoint.GET_WIDGET_BY_ID;
import static org.epam.core.api.ReportPortalApiService.Endpoint.UPDATE_WIDGET_BY_ID;
import static org.epam.core.api.RestClientConfig.getRequestSpecification;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.epam.core.api.filter.ReportPortalAuthorizationFilter;
import org.epam.core.props.ReportPortalProperties;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReportPortalApiService extends AbstractApi {

    private final ReportPortalProperties properties;
    private final ReportPortalAuthorizationFilter authFilter;

    @Override
    protected RequestSpecification getClient() {
        return getRequestSpecification(properties.getBaseUri()).filter(authFilter);
    }

    public Response createWidget(Object data, String projectName) {
        return getClient()
            .body(data)
            .post(CREATE_WIDGET.getName(), projectName);
    }

    public Response getWidgetById(String projectName, String widgetId) {
        return getClient()
            .get(GET_WIDGET_BY_ID.getName(), projectName, widgetId);
    }

    public Response updateWidgetById(Object data, String projectName, String widgetId) {
        return getClient()
            .body(data)
            .put(UPDATE_WIDGET_BY_ID.getName(), projectName, widgetId);
    }

    @AllArgsConstructor
    public enum Endpoint {

        CREATE_WIDGET("api/v1/{projectName}/widget"),
        GET_WIDGET_BY_ID("api/v1/{projectName}/widget/{widget_id}"),
        UPDATE_WIDGET_BY_ID("api/v1/{projectName}/widget/{widget_id}");

        @Getter
        private String name;
    }
}
