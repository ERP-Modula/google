package modula.platform.googledocs.configuration;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import modula.platform.googledocs.domain.entity.Category;
import modula.platform.googledocs.domain.entity.ModuleShortInfo;
import modula.platform.googledocs.domain.entity.actions.ActionShortInfo;
import modula.platform.googledocs.domain.entity.triggers.TriggerShortInfo;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class ModuleConfiguration {

    private final ModuleProperties moduleProperties;

    private final List<ActionShortInfo> actions = new ArrayList<>();
    private final List<TriggerShortInfo> triggers = new ArrayList<>();

    @PostConstruct
    private void initActionsAndTriggers() {
        ConfigurationUtils.putAvailableActionsShortInfo(actions);
        ConfigurationUtils.putAvailableTriggersShortInfo(triggers);
    }

    private static List<String> getCategories() {
        return Arrays.stream(Category.values())
                .map(Category::getName)
                .collect(Collectors.toList());
    }

    public ModuleShortInfo getModuleModel() {
        return ModuleShortInfo.builder()
                .id(moduleProperties.uuid)
                .name(moduleProperties.name)
                .label(moduleProperties.label)
                .description(moduleProperties.description)
                .theme(moduleProperties.theme)
                .iconPath(moduleProperties.iconPath)
                .isPublic(moduleProperties.isPublic)
                .actions(actions)
                .triggers(triggers)
                .categories(getCategories())
                .build();
    }

}
