package modula.platform.googledocs.configuration;

import jakarta.annotation.PostConstruct;
import modula.platform.googledocs.domain.command.Command;
import modula.platform.googledocs.domain.entity.triggers.Trigger;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CQRSConfiguration {
    private final Map<String, Command> nameToCommandMap = new HashMap<>();
    private final Map<String, Trigger> nameToTriggerMap = new HashMap<>();

    @PostConstruct
    private void initMaps() {

    }
}
