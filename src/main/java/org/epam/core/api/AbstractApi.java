package org.epam.core.api;

import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractApi {

    protected abstract RequestSpecification getClient();
}
