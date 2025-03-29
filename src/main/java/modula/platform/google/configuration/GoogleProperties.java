package modula.platform.google.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class GoogleProperties {

    @Value("${google-docs.application.client-id}")
    private String clientId;

    @Value("${google-docs.application.client-secret}")
    private String clientSecret;

    @Value("${google-docs.application.redirect-uri}")
    private String redirectUri;
}