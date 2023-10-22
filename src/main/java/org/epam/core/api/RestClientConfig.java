package org.epam.core.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RestClientConfig {

    public static RequestSpecification getRequestSpecification(String url) {
        return RestAssured
            .given()
            .baseUri(url)
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON);
    }
}
