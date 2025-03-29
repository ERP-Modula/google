package modula.platform.googledocs.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class ModuleProperties {
    @Value("${google-docs.module.uuid}")
    UUID uuid;
    @Value("${google-docs.module.name}")
    String name;
    @Value("${google-docs.module.label}")
    String label;
    @Value("${google-docs.module.description}")
    String description;
    @Value("${google-docs.module.iconPath}")
    String iconPath;
    @Value("${google-docs.module.isPublic}")
    Boolean isPublic;
    @Value("${google-docs.module.theme}")
    String theme;
}
