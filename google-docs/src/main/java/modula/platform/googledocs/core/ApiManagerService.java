package modula.platform.googledocs.core;

import lombok.RequiredArgsConstructor;
import modula.platform.googledocs.configuration.ModuleConfiguration;
import modula.platform.googledocs.domain.entity.ModuleInfo;
import modula.platform.googledocs.domain.entity.ModuleShortInfo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiManagerService {

    private final ModuleConfiguration moduleConfiguration;

    public ModuleInfo getModuleInfo() {
        ModuleInfo moduleInfo = new ModuleInfo();
        moduleInfo.setShortInfo(moduleConfiguration.getModuleModel());
        return moduleInfo;
    }

    public ModuleShortInfo getModuleShortInfo() {
        return moduleConfiguration.getModuleModel();
    }
}
