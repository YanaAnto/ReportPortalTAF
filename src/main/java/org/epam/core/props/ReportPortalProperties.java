package org.epam.core.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("report-portal")
public class ReportPortalProperties {

    private String baseUri;
    private String username;
    private String password;
    private String token;
    private String projectName;
}
