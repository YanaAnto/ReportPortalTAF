package org.epam.core.api.filter;

import static com.google.common.net.HttpHeaders.AUTHORIZATION;

import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.spi.AuthFilter;
import lombok.RequiredArgsConstructor;
import org.epam.core.props.ReportPortalProperties;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReportPortalAuthorizationFilter implements AuthFilter {

    private final ReportPortalProperties properties;

    @Override
    public Response filter(final FilterableRequestSpecification requestSpec,
        final FilterableResponseSpecification responseSpec,
        final FilterContext ctx) {
        requestSpec.replaceHeader(AUTHORIZATION, "Bearer " + properties.getToken());
        return ctx.next(requestSpec, responseSpec);
    }
}
