package modula.platform.googledocs.core;

import lombok.RequiredArgsConstructor;
import modula.platform.googledocs.configuration.ConfigurationUtils;
import modula.platform.googledocs.configuration.ModuleConfiguration;
import modula.platform.googledocs.domain.entity.ModuleInfo;
import modula.platform.googledocs.domain.entity.ModuleShortInfo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiManagerService {

    private final ModuleConfiguration moduleConfiguration;

    public ModuleInfo getModuleInfo() {
        ModuleShortInfo moduleShortInfo = moduleConfiguration.getModuleModel();
        ModuleInfo moduleInfo = ModuleInfo.builder()
                .id(moduleShortInfo.getId())
                .name(moduleShortInfo.getName())
                .label(moduleShortInfo.getLabel())
                .description(moduleShortInfo.getDescription())
                .theme(moduleShortInfo.getTheme())
                .iconPath(moduleShortInfo.getIconPath())
                .isPublic(moduleShortInfo.getIsPublic())
                .build();

        moduleInfo.setActions(ConfigurationUtils.getAvailableActionsInfo());
        moduleInfo.setTriggers(ConfigurationUtils.getAvailableTriggerInfo());

        return moduleInfo;
    }

    public ModuleShortInfo getModuleShortInfo() {
        return moduleConfiguration.getModuleModel();
    }
}
