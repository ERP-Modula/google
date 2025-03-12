package modula.platform.googledocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
public class GoogleDocsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoogleDocsApplication.class, args);
    }

}
