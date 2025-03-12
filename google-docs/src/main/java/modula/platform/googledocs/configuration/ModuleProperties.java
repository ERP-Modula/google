package modula.platform.googledocs.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class ModuleProperties {
    @Value("${google-docs.module.name}")
    String name;
    @Value("${google-docs.module.uuid}")
    UUID uuid;
}
