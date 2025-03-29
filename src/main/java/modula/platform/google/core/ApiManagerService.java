package modula.platform.google.core;

import com.modula.common.domain.moduleconfiguration.ModuleConfiguration;
import lombok.RequiredArgsConstructor;
//import modula.platform.googledocs.repository.ActionInterfaceRepository;
import modula.platform.google.repository.ModuleConfigurationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiManagerService {

//    private final ModuleConfiguration moduleConfiguration;
    private final ActionService actionService;
//    private final ActionInterfaceRepository actionInterfaceRepository;
    private final ModuleConfigurationRepository moduleConfigurationRepository;

    public ModuleConfiguration getModuleInfo() {
//        ModuleShortInfo moduleShortInfo = moduleConfiguration.getModuleModel();
//        ModuleInfo moduleInfo = ModuleInfo.builder()
//                .id(moduleShortInfo.getId())
//                .name(moduleShortInfo.getName())
//                .label(moduleShortInfo.getLabel())
//                .description(moduleShortInfo.getDescription())
//                .theme(moduleShortInfo.getTheme())
//                .iconPath(moduleShortInfo.getIconPath())
//                .isPublic(moduleShortInfo.getIsPublic())
//                .build();
//
//        List<Action> actionList = actionService.getAvailableActions();
//
//        moduleInfo.setActions(actionList);
//        moduleInfo.setTriggers(ConfigurationUtils.getAvailableTriggerInfo());
//
//        return moduleInfo;
        return moduleConfigurationRepository.findByName("googledocs").orElseThrow();
    }
//
//    public ModuleConfigurationShortInfoDTO getModuleShortInfo() {
//        ModuleConfiguration configuration = getModuleInfo();
//        return moduleConfiguration.getModuleModel();
//    }
}
