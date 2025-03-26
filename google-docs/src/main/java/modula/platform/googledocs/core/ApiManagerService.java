package modula.platform.googledocs.core;

import com.google.api.services.drive.model.File;
import lombok.RequiredArgsConstructor;
import modula.platform.googledocs.configuration.ConfigurationUtils;
import modula.platform.googledocs.configuration.ModuleConfiguration;
import modula.platform.googledocs.domain.entity.ModuleInfo;
import modula.platform.googledocs.domain.entity.ModuleShortInfo;
import modula.platform.googledocs.domain.entity.actions.Action;
import modula.platform.googledocs.domain.entity.field.ActionInterface;
import modula.platform.googledocs.repository.ActionInterfaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiManagerService {

    private final ModuleConfiguration moduleConfiguration;
    private final ActionService actionService;
    private final ActionInterfaceRepository actionInterfaceRepository;

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

        List<Action> actionList = actionService.getAvailableActions();

        moduleInfo.setActions(actionList);
        moduleInfo.setTriggers(ConfigurationUtils.getAvailableTriggerInfo());

        return moduleInfo;
    }

    public ModuleShortInfo getModuleShortInfo() {
        return moduleConfiguration.getModuleModel();
    }
}
