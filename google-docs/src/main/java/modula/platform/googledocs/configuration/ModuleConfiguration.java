package modula.platform.googledocs.configuration;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import modula.platform.googledocs.domain.entity.Module;
import modula.platform.googledocs.domain.entity.actions.Action;
import modula.platform.googledocs.domain.entity.triggers.Trigger;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ModuleConfiguration {

    private final ModuleProperties moduleProperties;

    private final List<Action> actions = new ArrayList<>();
    private final List<Trigger> triggers = new ArrayList<>();

    @PostConstruct
    private void initActionsAndTriggers() {
        ConfigurationUtils.putAvailableActions(actions);
        ConfigurationUtils.putAvailableTriggers(triggers);
    }

    public Module getModuleModel() {
        Module module = new Module();
        module.setId(moduleProperties.uuid);
        module.setUniqueName(moduleProperties.name);
        module.setTriggers(triggers);
        module.setActions(actions);
        return module;
    }

}
