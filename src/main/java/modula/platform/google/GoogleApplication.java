package modula.platform.google;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({
        "com.modula.common.domain.moduleconfiguration",
        "package modula.platform.google"
})
public class GoogleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoogleApplication.class, args);
    }

}
