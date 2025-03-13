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
        ModuleInfo moduleInfo = null;

        // возможно будут не всегда доступные действия и добавлять их можно здесь

        return moduleInfo;
    }

    public ModuleShortInfo getModuleShortInfo() {
        ModuleShortInfo moduleShortInfo = moduleConfiguration.getModuleModel();

        return moduleShortInfo;
    }
}
