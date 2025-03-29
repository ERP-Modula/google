package modula.platform.googledocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({
        "com.modula.common.domain.moduleconfiguration",
        "package modula.platform.googledocs"
})
public class GoogleDocsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoogleDocsApplication.class, args);
    }

}
